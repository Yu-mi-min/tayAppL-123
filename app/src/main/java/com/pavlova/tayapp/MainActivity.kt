package com.pavlova.tayapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.Utils.DB_TYPE
import com.pavlova.tayapp.navigation.*
import com.pavlova.tayapp.ui.theme.TayAppTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TayAppTheme {


                val context = LocalContext.current
                val mViewModel: MainViewModel =
                    viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                val navController = rememberNavController()


                    //  var   currentScreen by rememberSaveable { mutableStateOf() }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text ="ТАУ" )
                                    if (DB_TYPE.value.isNotEmpty()){
                                        Icon(imageVector = Icons.Default.ExitToApp,
                                            contentDescription = "",
                                            modifier = Modifier.clickable {
                                                mViewModel.signOut {
                                                    errorEx = true
                                                    navController.navigate(NavRoute.Start.route){
                                                        popUpTo(NavRoute.Start.route){
                                                            inclusive = true
                                                        }
                                                    }
                                                }
                                            }
                                        )
                                    }
                                }
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = {

                                        scope.launch {
                                            scaffoldState.drawerState.open()
                                        }
                                    },
                                ) {
                                    Icon(
                                        Icons.Rounded.Menu,
                                        contentDescription = ""
                                    )
                                }
                            })
                    },

                    drawerContent = {

                        Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
                    }
           /*         drawerContent = { DrawerMenu() },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {

                            NavHostController(mViewModel, navController)
                        }
                    }*/

                )
                {NavHostController(mViewModel, navController)}
              /*  Scaffold (

                    topBar = {
                            TopAppBar(

                                title = {
                                   Text(text = "Hallo") },
                                backgroundColor = Color.LightGray,
                                contentColor = Color.Black,
                                elevation = 12.dp
                                ){

                                IconButton(onClick = {scope.launch {
                                    scaffoldState.drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }})
                                //нужно тут переделать заголовок тулбара под мстоположение
                                {Icon(Icons.Filled.Menu, contentDescription = "Меню") }
                                //Text("METANIT.COM", fontSize = 22.sp)
                                Spacer(Modifier.weight(1f, true))
                            }
                   },

                    scaffoldState = scaffoldState,
                    drawerContent = { DrawerMenu() },
                   content = {
                       Surface(
                           modifier = Modifier.fillMaxSize(),
                           color = MaterialTheme.colors.background
                       ) {

                           NavHostController(mViewModel)
                       }
                   }

               )*/
               }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TayAppTheme {

    }
}


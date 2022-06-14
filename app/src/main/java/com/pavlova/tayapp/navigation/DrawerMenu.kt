package com.pavlova.tayapp.navigation

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.blue95BDF1 else android.R.color.transparent


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {


            Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(

            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}
@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){
    val activity = (LocalContext.current as? Activity)
    val items = listOf(
        //TODO сделать ссылку в меню на список задач
        // + сделать ссылку на заметки (если они будут)
       // NavigationItem.Profile,
        NavigationItem.Home,
        NavigationItem.Contents,
        NavigationItem.TestContents,
        NavigationItem.History,
        //NavigationItem.TaskContents,
       // NavigationItem.Notes,
    )

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
               // .background(Color.Green)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.jinx),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(horizontal = 0.1.dp)
                    .padding(vertical = 0.1.dp)


            )

        }


        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }
        Row(

            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { activity?.finish() }
                .height(45.dp)
                //.background(colorResource(id = background))
                .padding(start = 10.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_exit),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Black),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = Constants.Keys.EXIT,
                fontSize = 16.sp,
                color = Color.Black
            )
    }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Project by Yuyumi",
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}

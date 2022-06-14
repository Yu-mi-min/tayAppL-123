package com.pavlova.tayapp.screens

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.MainViewModel
import com.pavlova.tayapp.MainViewModelFactory
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.*
import com.pavlova.tayapp.errorEx
import com.pavlova.tayapp.model.AccModel
import com.pavlova.tayapp.navigation.Drawer
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants

@OptIn(ExperimentalMaterialApi::class)
//@Composable
/*fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {

    //    для настройки текстовых полей
    var login by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var password by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var mainText by remember { mutableStateOf(Constants.Keys.EMPTY) }

//    переменные для обновления полей(пунктов) окна с текстом
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
//для обработки кнопок обновления окна
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 32.dp)
                        .padding(horizontal = 8.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Text(
                        textAlign = TextAlign.Start,
                        text = Constants.Keys.LOG_IN,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .padding(bottom = 16.dp)
                    )
//                    текстовые поля
                    OutlinedTextField(
                        value = login,
                        onValueChange = { login = it },
                        label = { Text(text = Constants.Keys.LOGIN_TEXT) },
                        isError = login.isEmpty()
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = Constants.Keys.PASSWORD_TEXT) },
                        isError = password.isEmpty()
                    )

                    Button(
                        modifier = Modifier.offset(x = 100.dp),
                        onClick = {
                            LOGIN = login
                            PASSWORD = password
                           viewModel.initDatabase(TYPE_FIREBASE){
                               DB_TYPE.value = TYPE_FIREBASE
                               navController.navigate(NavRoute.Task.route)
                               Log.d("checkData", "Авторизация прошла успешно")
                           }
                        },
                        enabled = login.isNotEmpty() && password.isNotEmpty()
                    ) {
                        Text(text = Constants.Keys.SIGN_IN,
                            textAlign = TextAlign.Center)
                    }

                }
            }
        }
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = Constants.Keys.MAIN_MENU,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 32.dp)
                )
                Button(
                    onClick = {
                        viewModel.initDatabase(TYPE_ROOM) {
                            DB_TYPE.value = TYPE_ROOM
                            navController.navigate(route = NavRoute.Contents.route)
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)

                ) {
                    Text(text = Constants.Keys.CONTENTS_TEXT)

                }
                Button(
                    onClick = {
                        viewModel.initDatabase(TYPE_ROOM) {
                            DB_TYPE.value = TYPE_ROOM
                            navController.navigate(route = NavRoute.ContentsTest.route)
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)

                ) {
                    Text(text = CONTENTS_TEST)

                }
                Button(
                    onClick = {
                        coroutineScope.launch{
                            bottomSheetState.show()
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = LOG_IN)//вход в онлайн бд
                }
                val activity = (LocalContext.current as? Activity)
                Button(
                    onClick = { activity?.finish() },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)

                ) {
                    Text(text = Constants.Keys.EXIT)

                }
            }

        }

    }
}*/

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {

    //    для настройки текстовых полей
    val openDialog = remember { mutableStateOf(false) }
    var login by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var password by remember { mutableStateOf(Constants.Keys.EMPTY) }
    val scope = rememberCoroutineScope()

    Scaffold(
        drawerContent = {},
        modifier = Modifier.fillMaxSize(),

        ) {

        Surface {
            Image(
                painter = painterResource(id = R.drawable.be55),
                contentDescription = "",
                Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 228.dp, bottom = 32.dp)
                    .padding(horizontal = 8.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center


            ) {
                Text(
                    textAlign = TextAlign.Start,
                    text = Constants.Keys.LOG_IN,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(bottom = 16.dp)
                )
//                    текстовые поля
                OutlinedTextField(
                    value = login,
                    onValueChange = { login = it },
                    label = { Text(text = Constants.Keys.LOGIN_TEXT) },
                    isError = login.isEmpty()
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = Constants.Keys.PASSWORD_TEXT) },
                    isError = password.isEmpty()
                )

//                errorEx = true
                errorEx = false
                Button(
                    modifier = Modifier
                        .offset(x = 100.dp)
                        .padding(top = 22.dp),
                    onClick = {
                        scope.launch {
                            LOGIN = login
                            PASSWORD = password
                            openDialog.value = errorEx
                            viewModel.initDatabase(TYPE_FIREBASE) {
                                DB_TYPE.value = TYPE_ROOM
                                navController.navigate(NavRoute.Main.route)
                                Log.d("checkData", "Авторизация прошла успешно")
                            }
                            viewModel.initDatabase(TYPE_ROOM) {}
                        }
                    },
                    enabled = login.isNotEmpty() && password.isNotEmpty()
                ) {
                    Text(
                        text = Constants.Keys.SIGN_IN,
                        textAlign = TextAlign.Center
                    )
                }

                if (openDialog.value) {
                    AlertDialog(

                        onDismissRequest = {
                            openDialog.value = false
                        },
                        //title = { Text(text = "Подтверждение действия") },
                        text = { Text("Введены неверные данные", fontSize = 18.sp) },
                        buttons = {
                            Button(
                                onClick = { openDialog.value = false },
                                modifier = Modifier
                                    .offset(210.dp)
                                    .padding(end = 3.dp, bottom = 3.dp)
                            ) {
                                Text("OK", fontSize = 14.sp)
                            }
                        }
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    TayAppTheme{
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
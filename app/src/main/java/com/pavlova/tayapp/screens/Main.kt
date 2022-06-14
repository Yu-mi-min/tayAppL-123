package com.pavlova.tayapp.screens

import android.app.Activity
import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.pavlova.tayapp.Utils.Constants.Keys.CONTENTS_TASK
import com.pavlova.tayapp.errorEx
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .fillMaxHeight(),

    ) {
        Image(
            painter = painterResource(id = R.drawable.be55),
            contentDescription = "",
            Modifier.fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
        )
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
                   //.padding(vertical = 8.dp)

            ) {
                Text(text = Constants.Keys.CONTENTS_TEST)

            }
                Button(
           onClick = {
               //TODO сделать переход на задачи
               viewModel.initDatabase(TYPE_ROOM) {
                   DB_TYPE.value = TYPE_ROOM
                   navController.navigate(route = NavRoute.History.route)
               }
           },
           modifier = Modifier
               .width(200.dp)
               .padding(vertical = 8.dp)

       ) {
           Text(text = "Архив")

       }
            val activity = (LocalContext.current as? Activity)
            Button(
                onClick = { activity?.finish() },
                modifier = Modifier
                    .width(200.dp)
                    //.padding(vertical = 8.dp)

            ) {
                Text(text = Constants.Keys.EXIT)

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    TayAppTheme{
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
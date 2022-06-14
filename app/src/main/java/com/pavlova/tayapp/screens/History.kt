package com.pavlova.tayapp.screens

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.pavlova.tayapp.Utils.*
import com.pavlova.tayapp.forPdf.getResourceFromString
import com.pavlova.tayapp.model.AccModel
import com.pavlova.tayapp.model.TextModel
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme
import com.pdftron.pdf.config.ViewerConfig
import com.pdftron.pdf.controls.DocumentActivity

@Composable
fun HistoryScreen(navController: NavHostController, viewModel: MainViewModel) {


    val contents = viewModel.readAllContents().observeAsState(listOf()).value

    LazyColumn{
        items(contents){textModel ->
            HistoryItem(textModel = textModel, navController = navController )
        }
    }
    //кнопка добавления главы в содержание и в бд
    /*  Button(
                  modifier = Modifier.padding(top = 16.dp),
                  onClick = {
                      viewModel.addContent(textModel = TextModel(title = title, subtitle = subtitle, mainText = "test")){
                          navController.navigate(NavRoute.Contents.route)
                      }
                  }) {
                  Text(text = "Добавить главу")

              }*/

}

@Composable
fun HistoryItem(textModel: TextModel, navController: NavHostController){
    val contentId = when(DB_TYPE.value){
        TYPE_FIREBASE -> textModel.firebaseId
        TYPE_ROOM -> textModel.id
        else -> Constants.Keys.EMPTY
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable {
                navController.navigate(NavRoute.Text.route + "/${contentId}")
            },
        elevation = 6.dp
    ){
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
           // horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "${textModel.title}: ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                textAlign = TextAlign.Center,
                text = textModel.subtitle,
                fontSize = 20.sp,
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun prevHistoryScreen() {
    TayAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        HistoryScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}

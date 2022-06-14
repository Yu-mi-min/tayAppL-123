@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package com.pavlova.tayapp.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.MainViewModel
import com.pavlova.tayapp.MainViewModelFactory
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.Constants
import com.pavlova.tayapp.Utils.DB_TYPE
import com.pavlova.tayapp.Utils.TYPE_FIREBASE
import com.pavlova.tayapp.Utils.TYPE_ROOM
import com.pavlova.tayapp.model.TextModel
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun TextScreen(navController: NavHostController, viewModel: MainViewModel, contentId: String?) {
    val contents = viewModel.readAllContents().observeAsState(listOf()).value
    val content = when(DB_TYPE.value){
        TYPE_ROOM -> {
            contents.firstOrNull{it.id == contentId?.toInt()} ?: TextModel()
        }
        TYPE_FIREBASE -> {
            contents.firstOrNull{it.firebaseId == contentId} ?: TextModel()
        }
        else -> TextModel()
    }
//    для настройки текстовых полей
    var title by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var subtitle by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var mainText by remember { mutableStateOf(Constants.Keys.EMPTY) }

//    переменные для обновления полей(пунктов) окна с текстом
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
//для обработки кнопок обновления окна
    Scaffold(

        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 37.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
           // .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)

            ) {

                Column(
                    //modifier = Modifier.verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = content.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline,
                        //modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = content.subtitle,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.soi),
                        contentDescription = "",
                        Modifier
                            .size(width = 80.dp, height = 150.dp)

                    )

                    Text(
                        text = content.mainText,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .verticalScroll(rememberScrollState())
                    )

                    Text(
                        text = "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .verticalScroll(rememberScrollState())
                    )

                }

            }

        }
        //было тут
    }
//    нижнее меню в поле текста, добавила кнопку назад, поле для обновления заметки т.е. ввода новых данных, удаления
/*    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            //.padding(all = 8.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {
            navController.navigate(NavRoute.Contents.route)
        }) {
            Text(text = Constants.Keys.NAV_BACK)

        }
        Button(onClick = {
            viewModel.deleteContentText(textModel = content){
                navController.navigate(NavRoute.Contents.route)
            }
        }) {
            Text(text = Constants.Keys.DELETE)

        }
        Button(onClick = {
            coroutineScope.launch {
                title = content.title
                subtitle = content.subtitle
                mainText = content.mainText
                bottomSheetState.show()
            }
        }) {
            Text(text = Constants.Keys.UPDATE)

        }
    }*/
}
@Preview(showBackground = true)
@Composable
fun prevTextScreen() {
    TayAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        TextScreen(
            navController = rememberNavController(),
            viewModel = mViewModel,
            contentId = "1"
        )
    }
}
package com.pavlova.tayapp.screens

import android.R.attr.button
import android.R.attr.enabled
import android.app.Application
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.graphics.toColor
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.MainViewModel
import com.pavlova.tayapp.MainViewModelFactory
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.*
import com.pavlova.tayapp.files.TestsContainer
import com.pavlova.tayapp.files.contentTest
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.navigation.NavigationItem
import com.pavlova.tayapp.ui.theme.Purple200
import com.pavlova.tayapp.ui.theme.Purple500
import com.pavlova.tayapp.ui.theme.TayAppTheme
import com.pdftron.pdf.model.BookmarkButtonState
import com.pdftron.pdf.utils.Utils
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


public var resultCounter = mutableStateOf(0)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TestScreen(navController: NavHostController, viewModel: MainViewModel, contentTestModel: ContentTestModel) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Card(

                ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 32.dp)
                        .padding(horizontal = 8.dp)
                    ,horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Text(
                        textAlign = TextAlign.Start,
                        text = "Результаты вашего теста ${resultCounter.value}/${contentTest}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                           // .padding(horizontal = 10.dp)
                            .padding(bottom = 16.dp)
                    )
                    if (resultCounter.value == contentTest){
                        Text(text = "Отличная работа! Продолжайте изучение следующих тем",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            //fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 16.dp))
                    }
                    if (resultCounter.value <= contentTest/2){
                        Text(text = "Вам следуем вернуться к изучению этой главы и углубить свои знания",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            //fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 16.dp))
                    }
                    if (resultCounter.value > contentTest/2 && resultCounter.value< 2*contentTest/3){
                        Text(text = "Вам следуем повторить эту главу до того, как продолжить изучение следующих тем",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            //fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 16.dp))

                    }
                    if (resultCounter.value >= 2*contentTest/3 && resultCounter.value< contentTest){
                        Text(text = "Хорошо! Можете продолжить изучение следующих тем",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            //fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 16.dp))

                    }

                    Button(
                        modifier = Modifier.offset(x = 120.dp),
                        onClick = {
                            //TODO добавить сохранение результата в аккаунт
                            viewModel.addContent(textModel = TextModel(title = "Архив", subtitle = historySubtitle, mainText = "Результаты вашего теста ${resultCounter.value}/${contentTest}")){
                                navController.navigate(NavRoute.ContentsTest.route){
                                    popUpTo(NavRoute.ContentsTest.route){
                                        inclusive = true
                                    }
                                }
                            }

                            resultCounter.value = 0
                        },
                    ) {
                        Text(text = "Ок",
                            textAlign = TextAlign.Center)
                    }

                }
                }
            }
        }
    ) {
    Scaffold(
        modifier = Modifier
            //.verticalScroll(rememberScrollState()),
    )
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
            .verticalScroll(rememberScrollState())
        ) {

            TestsContainer(navController)
            Button(
                onClick = {
                    coroutineScope.launch{
                        bottomSheetState.show()

                    }
                },
                modifier = Modifier
                    .offset(x = 220.dp)
                    .padding(top = 24.dp)

            ) {
                Text(text = "Закончить тест")
            }
        }
    }
        Text(text = "")
    }

}


@Composable
 fun TestItem(testModel: TestModel, navController: NavHostController) {

    Column(
        modifier = Modifier
            //.fillMaxSize()
            .padding(8.dp)
    )
    {
            Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding( horizontal = 24.dp),
            textAlign = TextAlign.Start,

            text = "Вопрос:",
            fontSize = 18.sp,
        )
            Spacer(modifier = Modifier.width(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                //.padding(top = 10.dp)
                .height(300.dp)
        ) {
            Spacer(modifier = Modifier.width(3.dp))
            Image(

                painter = painterResource(
                    id = testModel.mainText
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(horizontal = 0.1.dp)
            )
        }
        Row(
            Modifier.fillMaxWidth()
        ) {
            addTestButton(testModel = testModel, navController)
        }
    }
}
@Composable
fun addTestButton(testModel: TestModel, navController: NavHostController){
    val composableScope = rememberCoroutineScope()
    val (buttonCount, setButtonCount) =
        rememberSaveable { mutableStateOf(0) }
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center

    ) {
        val design = remember { mutableStateOf(0) }

        if (testModel.answer1 != null) {

            val color = remember { mutableStateOf(Purple500) }
            Button(
                onClick = {
                    composableScope.launch {
                        design.value = 1
                        if (testModel.answer1 == testModel.rightAnswer) {
                            setButtonCount(buttonCount + 1)
                            resultCounter.value +=1
                            color.value = Green
                        } else {
                            color.value = Red
                        }
                    }
                    println("$buttonCount")
                },
                colors = buttonColors(disabledBackgroundColor = color.value),
                enabled = design.value != 1,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(text = testModel.answer1.toString())
            }
        }

        if (testModel.answer2 != null) {
            val color = remember { mutableStateOf(Purple500) }
            Button(
                onClick = {
                    composableScope.launch {
                        design.value = 1
                        if (testModel.answer2 == testModel.rightAnswer) {
                            setButtonCount(buttonCount + 1)
                            resultCounter.value +=1
                            color.value = Green
                        } else {
                            color.value = Red
                        }
                    }
                    println("$buttonCount")
                },
                colors = buttonColors(disabledBackgroundColor = color.value),
                enabled = design.value != 1,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(text = testModel.answer2.toString())
            }
        }
        if (testModel.answer3 != null) {
            val color = remember { mutableStateOf(Purple500) }
            Button(
                onClick = {
                    composableScope.launch {
                        design.value = 1
                        if (testModel.answer3 == testModel.rightAnswer) {
                            setButtonCount(buttonCount + 1)
                            resultCounter.value +=1
                            color.value = Green
                        } else {
                            color.value = Red
                        }
                    }
                    println("$buttonCount")
                },
                colors = buttonColors(disabledBackgroundColor = color.value),
                enabled = design.value != 1,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(text = testModel.answer3.toString())
            }
        }
        if (testModel.answer4 != null) {
            val color = remember { mutableStateOf(Purple500) }
            Button(
                onClick = {
                    composableScope.launch {
                        design.value = 1
                        if (testModel.answer4 == testModel.rightAnswer) {
                            setButtonCount(buttonCount + 1)
                            resultCounter.value +=1
                            color.value = Green
                        } else {
                            color.value = Red
                        }
                    }
                    println("$buttonCount")
                },
                colors = buttonColors(disabledBackgroundColor = color.value),
                enabled = design.value != 1,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(text = testModel.answer4.toString())
            }
        }
        if (testModel.answer5 != null) {
            val color = remember { mutableStateOf(Purple500) }
            Button(
                onClick = {
                    composableScope.launch {
                        design.value = 1
                        if (testModel.answer5 == testModel.rightAnswer) {
                            setButtonCount(buttonCount + 1)
                            resultCounter.value +=1
                            color.value = Green
                        } else {
                            color.value = Red
                        }
                    }
                    println("$buttonCount")
                },
                colors = buttonColors(disabledBackgroundColor = color.value),
                enabled = design.value != 1,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(text = testModel.answer5.toString())
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun prevTestScreen() {
    TayAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        TestScreen(navController = rememberNavController(), viewModel = mViewModel, contentTestModel = ContentTestModel())
    }
}
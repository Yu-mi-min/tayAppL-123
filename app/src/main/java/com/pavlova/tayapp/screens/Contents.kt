package com.pavlova.tayapp.screens

import android.app.Application
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Spinner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Icon
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.pavlova.tayapp.Utils.Constants.Keys.TITLE
import com.pavlova.tayapp.Utils.DB_TYPE
import com.pavlova.tayapp.Utils.TYPE_FIREBASE
import com.pavlova.tayapp.Utils.TYPE_ROOM
import com.pavlova.tayapp.forPdf.addPdfInRoom
import com.pavlova.tayapp.forPdf.getResourceFromString
import com.pavlova.tayapp.model.TextModel
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme
import com.pdftron.pdf.config.ViewerConfig
import com.pdftron.pdf.controls.DocumentActivity
import com.pdftron.pdf.struct.ContentItem
import com.pdftron.pdf.utils.Utils

@Composable
fun ContentsScreen(navController: NavHostController, viewModel: MainViewModel) {
    //val background = if(selected) R.color.purple_200 else android.R.color.transparent

    Scaffold() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        )

        {
            Card( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 5.dp),
                elevation = 6.dp,
                border = BorderStroke(2.dp, color = Color.LightGray)


                ) {
                Column() {

                    addTitle(title = "Глава I. Основные понятия")
                    ContentItem(
                        TextModel(
                            subtitle = "§1. Структура системы управления",
                            mainText = "raw/p1.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§2. Принцип работы регулятора",
                            mainText = "raw/p2.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§3. Классификация систем управления",
                            mainText = "raw/p3.pdf"
                        ), navController
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .padding(horizontal = 5.dp),
                elevation = 6.dp,
                border = BorderStroke(2.dp, color = Color.LightGray)) {
                Column() {


                    addTitle(title = "Глава II. Математические модели")
                    ContentItem(
                        TextModel(
                            subtitle = "§4. Основные понятия. Связь входа и выхода",
                            mainText = "raw/p4.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§5. Способы построения моделей",
                            mainText = "raw/p5.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§6. Линейность и нелинейность",
                            mainText = "raw/p6.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§7. Линеаризация уравнений",
                            mainText = "raw/p7.pdf"
                        ), navController
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .padding(horizontal = 5.dp),
                elevation = 6.dp,
                border = BorderStroke(2.dp, color = Color.LightGray)) {
                Column() {
                    addTitle(title = "Глава III. Математическое описание САУ")
                    ContentItem(
                        TextModel(
                            subtitle = "§8. Виды воздействий на САУ",
                            mainText = "raw/p8.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§9. Стандартная форма записи дифференциальных уравнений",
                            mainText = "raw/p9.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§10. Операционный метод описания линейных САУ. Основные свойства преобразования Лапласа",
                            mainText = "raw/p10.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§11. Передаточная функция. Свойства и особенности передаточной функции",
                            mainText = "raw/p11.pdf"
                        ), navController
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .padding(horizontal = 5.dp),
                elevation = 6.dp,
                border = BorderStroke(2.dp, color = Color.LightGray)) {
                Column() {
                    addTitle(title = "Глава IV. Структурные схемы САУ")
                    ContentItem(
                        TextModel(
                            subtitle = "§12. Обозначения в структурных схемах. Передаточные функции типовых соединений звеньев",
                            mainText = "raw/p12.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§13. Дополнительные правила преобразования структурных схем",
                            mainText = "raw/p13.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§14. Определение передаточных функций замкнутой САУ по ее структурной схеме",
                            mainText = "raw/p14.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "Разбор задач",
                            mainText = "raw/tk1g4.pdf"
                        ), navController
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .padding(horizontal = 5.dp),
                elevation = 6.dp,
                border = BorderStroke(2.dp, color = Color.LightGray)) {
                Column() {
                    addTitle(title = "Глава V. Характеристики САУ")

                    ContentItem(
                        TextModel(
                            subtitle = "§15. Частотные характеристики",
                            mainText = "raw/p15.pdf"
                        ),
                        navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§16. Логарифмические частотные характеристики",
                            mainText = "p16.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = "§17. Соотношения взаимосвязи характеристик САУ между собой и передаточной функцией",
                            mainText = "raw/p17.pdf"
                        ), navController
                    )
                    ContentItem(
                        TextModel(
                            subtitle = " Разбор задач",
                            mainText = "raw/tk2g5.pdf"
                        ), navController
                    )
                }
            }
                // ContentItem( navController)
        }


    }
 /*   LazyColumn{
        items(contents){textModel ->
            ContentItem(textModel = textModel, navController = navController )
        }

    }*/


}

@Composable
fun ContentItem(textModel: TextModel, navController: NavHostController) {
    val context = LocalContext.current
    val config = ViewerConfig.Builder()
        .multiTabEnabled(false)
        .documentEditingEnabled(false)
        .build();

    val contentId = when (DB_TYPE.value) {
        TYPE_FIREBASE -> textModel.firebaseId
        TYPE_ROOM -> textModel.id
        else -> Constants.Keys.EMPTY
    }

    Column() {
        Text(

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .clickable {

                    val docRes = getResourceFromString(context, textModel.mainText)
                    DocumentActivity.openDocument(
                        context,
                        docRes,
                        config
                    )
                },
            textAlign = TextAlign.Start,
            text = textModel.subtitle,
            fontSize = 18.sp,
        )

    }
}
@Composable
fun addTitle (title: String){
    Text(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        text = title,
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Start,
    )
}


@Preview(showBackground = true)
@Composable
fun prevContentsScreen() {
    TayAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        ContentsScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
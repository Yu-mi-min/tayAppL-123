package com.pavlova.tayapp.screens

import android.app.Application
import android.graphics.drawable.Icon
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TextModel
import com.pavlova.tayapp.navigation.NavRoute
import com.pavlova.tayapp.ui.theme.TayAppTheme
import kotlin.math.round

var testId: Int = 0
var historySubtitle = ""

@Composable

fun ContentsTestScreen(navController: NavHostController, viewModel: MainViewModel) {

    Scaffold() {
        Column(
            modifier = Modifier
            .verticalScroll(rememberScrollState()),
        ) {

            ContentTestItem(ContentTestModel(id = 1, title = "Тест №1. К главе I"), navController = navController)
            ContentTestItem(ContentTestModel(id = 2, title = "Тест №2. К главе II"), navController = navController)
            ContentTestItem(ContentTestModel(id = 3, title = "Тест №3. К главе III"), navController = navController)
            ContentTestItem(ContentTestModel(id = 4, title = "Тест №4. К главе III"), navController = navController)
            ContentTestItem(ContentTestModel(id = 5, title = "Тест №5. К главе IV"), navController = navController)
            ContentTestItem(ContentTestModel(id = 6, title = "Тест №6. К главе IV"), navController = navController)
            ContentTestItem(ContentTestModel(id = 7, title = "Тест №7. К главе V"), navController = navController)
            ContentTestItem(ContentTestModel(id = 8, title = "Тест №8. К главе V"), navController = navController)
            ContentTestItem(ContentTestModel(id = 9, title = "Тест №9. К главе V"), navController = navController)
            ContentTestItem(ContentTestModel(id = 10, title = "Итоговый тест"), navController = navController)

        }
    }


}
@Composable
fun ContentTestItem(contentTestModel: ContentTestModel, navController: NavHostController) {
    Card(

        modifier = Modifier
            //.clip(shape = RoundedCornerShape(50.dp))
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable {
                historySubtitle = contentTestModel.title
                testId = contentTestModel.id
                navController.navigate(NavRoute.Test.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_ballot_24),contentDescription ="${contentTestModel.title}")// ic_baseline_ballot_24
                Text(
                    text = contentTestModel.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun prevContentsTestScreen() {
    TayAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        ContentsTestScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
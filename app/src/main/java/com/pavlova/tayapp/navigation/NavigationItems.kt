package com.pavlova.tayapp.navigation

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.Constants
import com.pavlova.tayapp.Utils.Constants.Keys.ACCOUNT
import com.pavlova.tayapp.Utils.Constants.Screens.CONTENTS_NOTE_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.CONTENTS_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.CONTENTS_TASK_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.CONTENTS_TEST_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.HISTORY_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.MAIN_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.TEST_SCREEN
import com.pavlova.tayapp.Utils.Constants.Screens.TEXT_SCREEN

sealed class NavigationItem(var route: String, var icon: Int, var title: String)
{
    //todo добавить иконки меню
    object Profile : NavigationItem(ACCOUNT, R.drawable.ic_profile, "Аккаунт")
    object Home : NavigationItem(MAIN_SCREEN, R.drawable.ic_home, "Главное меню",)
    object Contents : NavigationItem(CONTENTS_SCREEN, R.drawable.ic_read_more, "Оглавление")
    object Notes : NavigationItem(CONTENTS_NOTE_SCREEN, R.drawable.ic_read_more, "Заметки")
    object TestContents : NavigationItem(CONTENTS_TEST_SCREEN, R.drawable.ic_read_more, "Тесты")
    object History : NavigationItem(HISTORY_SCREEN, R.drawable.ic_read_more, "Архив")
    //object Exit : NavigationItem("", R.drawable.ic_exit, "Выход")
}

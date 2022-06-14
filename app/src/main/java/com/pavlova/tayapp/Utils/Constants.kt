package com.pavlova.tayapp.Utils

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.pavlova.tayapp.database.DatabaseRepository
import com.pavlova.tayapp.navigation.NavRoute
import java.net.PasswordAuthentication

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_DATABASE = "FIREBASE DATABASE"
const val FIREBASE_ID = "firebaseId"

lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String
lateinit var FILE_NAME: String
var DB_TYPE = mutableStateOf("")

object Constants{
    object Keys {
        const val CONTENTS_DATABASE = "contents_database"
        const val TEXT_TABLE = "text_table"
        const val TEST_TABLE = "test_table"
        const val CONTENT_TEST_TABLE = "Content_test_table"


        const val PARAGRAPH_TABLE = "paragraph_table"
        const val ADD_CONTENT = "Добавить главу"
        const val CHECK_RESULT = "Проверить решение"
        const val SHOW_SOLUTION = "Показать решение"
        const val MAIN_MENU = "Главное меню"
        const val CONTENTS_TEXT = "Содержание"
        const val CONTENTS_TEST = "Тесты"
        const val CONTENTS_TASK = "Задачи"
        const val EXIT = "Выход"
        const val ID = "Id"
        const val NONE = "none"
        const val DELETE = "Удалить"
        const val UPDATE = "Обновить"
        const val NAV_BACK = "Назад"
        const val NAV_FORWARD = "Вперед"
        const val CHANGE = "Изменить"
        const val EMPTY = ""
        const val SIGN_IN = "Войти"
        const val LOG_IN = "Авторизация/Регистрация"
        const val LOGIN_TEXT = "Введите вашу почту"
        const val PASSWORD_TEXT = "Введите пароль"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val MAIN_TEXT = "mainText"
        const val PARAGRAPH1 = "paragraphList1"

        const val ACCOUNT = "account"


    }
    object Screens {
        const val HOME_SCREEN = "home_screen"
        const val MAIN_SCREEN = "main_screen"
        const val CONTENTS_SCREEN = "contents_screen"
        const val TEXT_SCREEN = "text_screen"
        const val TEST_SCREEN = "test_screen"
        const val CONTENTS_TEST_SCREEN = "contents_test_screen"
        const val TASK_SCREEN = "task_screen"
        const val CONTENTS_TASK_SCREEN = "task_screen"
        const val CONTENTS_NOTE_SCREEN = "note_screen"
        const val HISTORY_SCREEN = "history_screen"

    }
}
/*
fun Modifier.verticalScroll(
    state: ScrollState,
    enabled: Boolean = true,
    flingBehavior: FlingBehavior? = null,
    reverseScrolling: Boolean = false
): Modifier{}*/

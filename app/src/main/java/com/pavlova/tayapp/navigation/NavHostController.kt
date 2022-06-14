package com.pavlova.tayapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.MainViewModel
import com.pavlova.tayapp.Utils.Constants
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.screens.*


sealed class NavRoute(val route: String) {
    object Start: NavRoute(Constants.Screens.HOME_SCREEN)
    object Main: NavRoute(Constants.Screens.MAIN_SCREEN)
    object Contents: NavRoute(Constants.Screens.CONTENTS_SCREEN)
    object Text: NavRoute(Constants.Screens.TEXT_SCREEN)
    object Test: NavRoute(Constants.Screens.TEST_SCREEN)
    object ContentsTest: NavRoute(Constants.Screens.CONTENTS_TEST_SCREEN)
    object ContentsTask: NavRoute(Constants.Screens.CONTENTS_TASK_SCREEN)
    object Task: NavRoute(Constants.Screens.TASK_SCREEN)
    object ContentsNote: NavRoute(Constants.Screens.CONTENTS_NOTE_SCREEN)
    object History: NavRoute(Constants.Screens.HISTORY_SCREEN)


}

@Composable
fun NavHostController(mViewModel: MainViewModel, navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route){StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route){MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Contents.route){ContentsScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Text.route+"/{${Constants.Keys.ID}}"){backStackEntry ->
            TextScreen(navController = navController, viewModel = mViewModel,
               contentId = backStackEntry.arguments?.getString(Constants.Keys.ID)) }
        composable(NavRoute.Test.route){TestScreen(navController = navController, viewModel = mViewModel, contentTestModel = ContentTestModel()) }
        composable(NavRoute.ContentsTest.route){ContentsTestScreen(navController = navController, viewModel = mViewModel) }
        //composable(NavRoute.ContentsTask.route){ContentsTaskScreen(navController = navController, viewModel = mViewModel) }
       // composable(NavRoute.ContentsNote.route){ContentsNoteScreen(navController = navController, viewModel = mViewModel) }
        //composable(NavRoute.Task.route){TaskScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.History.route){HistoryScreen(navController = navController, viewModel = mViewModel) }

    }

}
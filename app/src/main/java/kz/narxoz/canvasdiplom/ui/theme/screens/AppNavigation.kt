package kz.narxoz.canvasdiplom.ui.theme.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
//
//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//    val context = LocalContext.current
//    val viewModel: TasksViewModel = viewModel()
//
//    NavHost(navController = navController, startDestination = Screen.Auth.route) {
//        composable(Screen.Auth.route) {
//            AuthorizationScreen(
//                modifier = Modifier,
//                viewModel = viewModel
////                onAuthorized = {
////                    navController.navigate(Screen.Main.route) {
////                    popUpTo(Screen.Auth.route) { inclusive = true }
////                }
////            }
//            )
//        }
//
//        composable(Screen.Main.route) {
//            CanvasApp(
//                modifier = Modifier,
////                context = context,
////                navController = navController,
//            )
////            MainScreen(navController)
//        }
//    }
//}

@Composable
fun AppNavigation(
) {
    MainScreen()
}

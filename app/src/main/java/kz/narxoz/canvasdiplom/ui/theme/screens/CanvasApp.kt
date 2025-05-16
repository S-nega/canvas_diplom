package kz.narxoz.canvasdiplom.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalAssignmentDataProvider
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Assignment
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.components.BaseBottomBar
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar
import kz.narxoz.canvasdiplom.ui.theme.screens.courses.CourseRegistrationScreen
import kz.narxoz.canvasdiplom.ui.theme.screens.courses.CoursesScreen
import kz.narxoz.canvasdiplom.ui.theme.screens.tasks.TaskDetailsScreen
import kz.narxoz.canvasdiplom.ui.theme.screens.tasks.TaskEditScreen
import kz.narxoz.canvasdiplom.ui.theme.screens.tasks.TasksScreen

//@Composable
//fun CanvasApp(//mainScreen
////    windowSize: WindowWidthSizeClass,
//    modifier: Modifier = Modifier,
////    context: Context,
//    navController: NavController
//){
////    val context = LocalContext.current
//
//    val viewModel: TasksViewModel = viewModel()
////    val uiState by viewModel.uiState.collectAsState()
//    val bottomNavController = rememberNavController()
//
//    val user = LocalUsersDataProvider.getUserByID("S1")
//    val course = LocalCoursesDataProvider.getCourseByID(1)
//
//
//    Scaffold (
//        topBar = {
//        },
//        bottomBar = {
//            BaseBottomBar(bottomNavController, viewModel, modifier)
//        }
//    ) { innerPadding ->
//        ProfileScreen(
//            modifier = Modifier
//                .padding(innerPadding),
//            user = user,
//            navController = navController,
//            viewModel = viewModel)
//    }
//}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: TasksViewModel = viewModel()

    val user = LocalUsersDataProvider.getUserByID(3)
    val courses = LocalCoursesDataProvider.getStaticCoursesData()
    val course = LocalCoursesDataProvider.getStaticCoursesData()[0]

    // i need to move sorting into another place !!!
    val assignments = if (user.role == UserRole.STUDENT) {
        LocalAssignmentDataProvider.getAssignmentsByStudentID(user.id)
//        LocalTasksDataProvider.getTasksByStudentID(user.id)
    } else {
        LocalAssignmentDataProvider.getStaticAssignmentData()
//        LocalTasksDataProvider.getStaticTasksData()
    }

    Scaffold(
        topBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            val title = when (currentRoute) {
                Screen.Profile.route -> "Profile"
                Screen.Calendar.route -> "Calendar"
                Screen.Courses.route -> "Courses"
                Screen.Info.route -> "Info Panel"
                else -> "App"
            }

            BaseTopBar(title = title, navController = navController)
        },
        bottomBar = {
            BaseBottomBar(navController = navController, viewModel = viewModel, modifier = Modifier)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Profile.route,
            modifier = Modifier
                .padding(padding)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            composable(Screen.Profile.route) { ProfileScreen(Modifier, user = user, navController = navController, viewModel = viewModel) }
            composable(Screen.Info.route) { InfoPanelScreen(Modifier, user, assignments, navController = navController) }
            composable(Screen.Calendar.route) { CalendarScreen(Modifier, navController) }
            composable(Screen.Courses.route) { CourseRegistrationScreen(Modifier, user, courses) }
//            composable(Screen.Courses.route) { CoursesScreen(Modifier, user, courses, navController) }
            composable(Screen.Tasks.route) { TasksScreen(Modifier, navController, user, course) }
            composable(Screen.TaskDetails.route) { backStackEntry ->
                val assignmentId = backStackEntry.arguments?.getLong("assignmentId")
                Log.d("TaskDetails", "Task id: ${backStackEntry.arguments?.getLong("assignmentId")}")
                Log.d("TaskDetails", "Task id: ${assignmentId}")
                if (assignmentId != null) {
                    TaskDetailsScreen(navController, viewModel, assignments.find { assignment: Assignment -> assignment.id == assignmentId }!!, user, course)
                }
            }
            composable(Screen.TaskEdit.route) { backStackEntry ->
                val assignmentId = backStackEntry.arguments?.getLong("assignmentId")
                Log.d("TaskDetails", "Task id: ${backStackEntry.arguments?.getLong("assignmentId")}")
                if (assignmentId != null) {
                    TaskEditScreen(assignments.find { assignment: Assignment -> assignment.id == assignmentId }!!, user)
                }
            }
        }
    }
}
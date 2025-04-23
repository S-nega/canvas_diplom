package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.components.BaseBottomBar
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar
import kz.narxoz.canvasdiplom.ui.theme.components.BottomNavigationBar
import kz.narxoz.canvasdiplom.ui.theme.screens.tasks.TasksScreen

@Composable
fun CanvasApp(//mainScreen
//    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
//    context: Context,
    navController: NavController
){
//    val context = LocalContext.current

    val viewModel: TasksViewModel = viewModel()
//    val uiState by viewModel.uiState.collectAsState()
    val bottomNavController = rememberNavController()

    val user = User(
        id = "S1",
        name = "John",
        surname = "Doe",
        contact = "+1234567890",
        email = "john.doe@example.com",
        login = "jdoe",
        password = "securepassword",
        role = UserRole.STUDENT,
        courses = mutableListOf()
    )
    val course = Course(
        id = 1,
        title = "Android Development",
        teacherID = "T2",
//        = User(
//            id = "t1",
//            name = "John",
//            surname = "Doe",
//            contact = "",
//            email = "",
//            login = "",
//            password = "",
//            role = UserRole.TEACHER,
//            courses = mutableListOf()
//        ),
        code = "ANDROID101",
        credits = 6,
        hoursPerWeek = 3,
        courseTable = mutableListOf(),
//        tasks = LocalTasksDataProvider.staticTasksData,
        studentsID = mutableListOf("s1", "s2")
    )


    Scaffold (
        topBar = {
//                 BaseTopBar(modifier = modifier, navController = navController, title = )
        },
        bottomBar = {
            BaseBottomBar(bottomNavController, viewModel, modifier)
//            BottomNavigationBar(bottomNavController)
        }
    ) { innerPadding ->
        ProfileScreen(
            modifier = Modifier
//                .fillMaxSize()
                .padding(innerPadding),
            user = user,
            navController = navController,
            viewModel = viewModel)

//        NavHost(
//            navController = bottomNavController,
//            startDestination = Screen.Profile.route,
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            composable(Screen.Profile.route) { ProfileScreen(modifier, user = user, viewModel) }
//            composable(Screen.Calendar.route) { CalendarScreen(modifier) }
//            composable(Screen.Courses.route) { CoursesScreen(modifier, user.courses) }
//            composable(Screen.InfoPanel.route) { InfoPanelScreen(modifier, user, course.tasks) }
//        }

//        AuthorizationScreen(
//            modifier = Modifier
//                .padding(innerPadding),
//            viewModel = viewModel
//        )
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: TasksViewModel = viewModel()

    val user = User(
        id = "S1",
        name = "John",
        surname = "Doe",
        contact = "+1234567890",
        email = "john.doe@example.com",
        login = "jdoe",
        password = "securepassword",
        role = UserRole.STUDENT,
        courses = mutableListOf()
    )
    val course = LocalCoursesDataProvider.getStaticCoursesData()[0]

    Scaffold(
        topBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            val title = when (currentRoute) {
                Screen.Profile.route -> "Profile"
                Screen.Calendar.route -> "Calendar"
                Screen.Courses.route -> "Courses"
                Screen.InfoPanel.route -> "Info Panel"
                else -> "App"
            }

            BaseTopBar(title = title, navController = navController)
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Profile.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Profile.route) { ProfileScreen(Modifier, user = user, navController = navController, viewModel = viewModel) }
//            composable(Screen.InfoPanel.route) { InfoPanelScreen(Modifier, user, course.tasks, navController = navController) }
            composable(Screen.Calendar.route) { CalendarScreen(Modifier, navController) }
//            composable(Screen.Courses.route) { CoursesScreen(Modifier, user.courses, navController) }
            composable(Screen.Tasks.route) { TasksScreen(Modifier, navController, user, course) }
//            composable(Screen.TaskDetails.route) { backStackEntry ->
//                val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
//                if (taskId != null) {
//                    TaskDetailsScreen(navController, viewModel, course.tasks[taskId], user, course)
//                }
//            }
        }
    }
}



//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//@Preview(showBackground = true)
//@Composable
//fun CanvasAppPreview() {
//    CanvasDiplomTheme {
////        val windowSize = calculateWindowSizeClass(this)
//        val context = LocalContext.current
//        CanvasApp(
//            modifier = Modifier,
////            context = context,
////            windowSize = windowSize.widthSizeClass,
//        )
//
//    }
//}

package kz.narxoz.canvasdiplom.ui.theme.screens.courses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.ListItem
import kz.narxoz.canvasdiplom.ui.theme.screens.Screen
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel

@Composable
fun CoursesScreen(
    modifier: Modifier,
    user: User,
    courses: List<Course>,
    navController: NavController,
){
//    BaseTopBar(modifier = modifier, navController = navController, title = "Courses")

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ){
        items(courses){course ->
            ListItem(
                user = user,
                title = course.title,
                description = course.description,
//                LocalUsersDataProvider.getUserByID(user.id).name + " "
//                        + LocalUsersDataProvider.getUserByID(user.id).surname,
                //+ "/n" + course.credits + " " + course.hoursPerWeek,
                navController = navController,
                route = Screen.Tasks.route
            ) {

            }
        }
    }
}

@Composable
fun CoursesBottomBar(
    modifier: Modifier
){ // may be it's better to give courses links to origin BottomBar ???
    Box(modifier = Modifier){
        IconButton(onClick = { /*OPEN PROFILE SCREEN*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Profile"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Info Panel"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Calendar"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Courses"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesListPreview() {
    CanvasDiplomTheme {

        val user = LocalUsersDataProvider.getUserByID(1)

        val viewModel: TasksViewModel = viewModel()
        val navController = rememberNavController()
        val courses = LocalCoursesDataProvider.getStaticCoursesData()

        CoursesScreen(modifier = Modifier, courses = courses, user = user, navController = navController)
    }
}
package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar
import kz.narxoz.canvasdiplom.ui.theme.components.ListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    modifier: Modifier,
    navController: NavController,
    user: User,
    course: Course
) {
    val viewModel: TasksViewModel = viewModel()

    Column {
        val isAbleAdding = user.role == UserRole.TEACHER
        val isAbleGrade = user.role == UserRole.STUDENT
//        BaseTopBar(
//            modifier = Modifier,
//            navController = navController,
//            course.title,
//            previousScreen = viewModel.navigateToDetailPage(),
//            nextScreen = viewModel.navigateToAddPage(),
//        )

        val filteredTasks = LocalTasksDataProvider.staticTasksData.filter { task: Task -> task.courseID == course.id }
        TasksList(user = user, filteredTasks = filteredTasks, course = course, navController = navController)
    }
}


@Composable
fun TasksList(
    viewModel: TasksViewModel = viewModel(),
    filteredTasks: List<Task>,
    user: User,
    course: Course,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
//            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(filteredTasks) { task ->
            ListItem(
                user = user,
                title = task.title,
                description = task.description,
                grade = task.scores.find { it.studentId == user.id }?.grade,
                navController = navController,
                route = Screen.TaskDetails.createRoute(task.id),
                onClick = { viewModel.navigateToDetailPage() }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    CanvasDiplomTheme {

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
        val viewModel: TasksViewModel = viewModel()
        val navController = rememberNavController()

        TasksScreen(Modifier, user = user, course = course, navController = navController)
    }
}
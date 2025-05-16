package kz.narxoz.canvasdiplom.ui.theme.screens.tasks

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
import kz.narxoz.canvasdiplom.data.LocalAssignmentDataProvider
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Assignment
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.ListItem
import kz.narxoz.canvasdiplom.ui.theme.screens.Screen

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

        val filteredTasks = LocalAssignmentDataProvider.getStaticAssignmentData().filter { assignment: Assignment -> assignment.assignmentGroupId == course.id }
        TasksList(user = user, filteredTasks = filteredTasks, course = course, navController = navController)
    }
}


@Composable
fun TasksList(
    viewModel: TasksViewModel = viewModel(),
    filteredTasks: List<Assignment>,
    user: User,
    course: Course,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
//            .fillMaxWidth()
//            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(filteredTasks) { task ->
            ListItem(
                user = user,
                title = task.title,
                description = task.description,
//                grade = task.scores.find { it.studentId == user.id }?.grade,
                navController = navController,
                route = Screen.TaskDetails.createRoute(task.id),
//                onClick = { viewModel.navigateToDetailPage(user, task) }
            ){}
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    CanvasDiplomTheme {

        val user = LocalUsersDataProvider.getUserByID(3)

        val course = LocalCoursesDataProvider.getStaticCoursesData()[0]
//        val viewModel: TasksViewModel = viewModel()
        val navController = rememberNavController()

        TasksScreen(Modifier, user = user, course = course, navController = navController)
    }
}
package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.ListItem
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import java.time.LocalDateTime


@Composable
fun InfoPanelScreen(
    modifier: Modifier,
    user: User,
    tasksList: List<Task>,
    navController: NavController
){
    val viewModel: TasksViewModel = viewModel()

    Column (
    ){
        InfoPanelDaysList(
            modifier = Modifier,
            user = user,
            tasksList = tasksList,
            navController = navController
        )
    }
}

@Composable
fun InfoPanelDaysList(
    modifier: Modifier,
    user: User,
    tasksList: List<Task>,
    navController: NavController
){
    val userTasks = getUserTasksSortedByDeadline(user.id)
    InfoPanelTasksListInDay(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        user = user,
        day = LocalDateTime.of(2024, 2, 20, 0, 0),
        sortedTasksList = userTasks,
        navController = navController
    )
}


@Composable
fun getUserTasksSortedByDeadline(currentUserId: String): List<Task> {
    return LocalTasksDataProvider.getTasksByStudentID(studentId = currentUserId)
}

@Composable
fun InfoPanelTasksListInDay(
    modifier: Modifier,
    user: User,
    day: LocalDateTime,
    sortedTasksList: List<Task>,
    navController: NavController
){
    Column (
        modifier = modifier
    ){
        Divider()
        Text(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
            text = "Tomorrow" //day.toString()
        )
        LazyColumn {
            items(sortedTasksList) { task ->
                ListItem(
                    user = user,
                    title = LocalCoursesDataProvider.getCourseByID(task.courseID).title.toString(),
                    description = task.title,
                    navController = navController,
                    route = Screen.TaskDetails.createRoute(task.id) //"AD001")//task.id)
                ) {

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InfoPanelPreview() {
    CanvasDiplomTheme {

        val user = LocalUsersDataProvider.getUserByID("S1")
        val course = LocalCoursesDataProvider.getStaticCoursesData()[0]
        val filteredTasks = LocalTasksDataProvider.getStaticTasksData().filter { task: Task -> task.courseID == course.id }
        val navController = rememberNavController()

        InfoPanelScreen(modifier = Modifier, user = user, tasksList = filteredTasks, navController = navController)
    }
}
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
import kz.narxoz.canvasdiplom.data.LocalAnswersDataProvider
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.ListItem
import java.time.LocalDateTime


@Composable
fun InfoPanelScreen(
    modifier: Modifier,
    user: User,
    tasksList: List<Task>,
    navController: NavController
){
    val viewModel: TasksViewModel = viewModel()
//    val bottomNavController = rememberNavController()

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
//    val tasksSortedByUser = tasksList.toSortedSet()
//    val tasksSortedByDate = tasksSortedByUser
    val userTasks = getUserTasksSortedByDeadline(user.id)
//    val userDeadlines = getUserDeadlines(tasksList, user.id)

//    val fakeDeadlines = listOf(
//        LocalDateTime.of(2024, 2, 20, 0, 0),
//        LocalDateTime.of(2024, 2, 21, 0, 0),
//        LocalDateTime.of(2024, 2, 22, 0, 0)
//    )

//    LazyColumn (
//        modifier = Modifier
//            .padding(dimensionResource(id = R.dimen.padding_medium))
//    ) {
//        items(fakeDeadlines) { day ->
    InfoPanelTasksListInDay(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        user = user,
        day = LocalDateTime.of(2024, 2, 20, 0, 0),
        sortedTasksList = userTasks,
        navController = navController
    )
//        }
//    }
}

//@Composable
//fun getUserDeadlines(tasks: List<Task>, currentUserId: String): List<LocalDateTime> {
//    return tasks
//        .filter { task -> task.scores.any { it.studentId == currentUserId } } // Filter tasks for the current user
//        .map { it.deadline } // Extract deadlines
//        .sorted() // Sort deadlines in ascending order
//}

@Composable
fun getUserTasksSortedByDeadline(currentUserId: String): List<Task> {
    return LocalTasksDataProvider.getTasksByStudentID(studentId = currentUserId)
//        .filter { task -> answers.filter { answer == task.id}}
//            //task.scores.any { it.studentId == currentUserId } } // Filter tasks for the current user
//        .sortedBy { it.deadline } // Sort by deadline

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
                    route = Screen.TaskDetails.createRoute(task.id)
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

//        val course = Course(
//            id = 1,
//            title = "Android Development",
//            teacher = User(
//                id = "t1",
//                name = "John",
//                surname = "Doe",
//                contact = "",
//                email = "",
//                login = "",
//                password = "",
//                role = UserRole.TEACHER,
//                courses = mutableListOf()
//            ),
//            code = "ANDROID101",
//            credits = 6,
//            hoursPerWeek = 3,
//            courseTable = mutableListOf(),
//            tasks = LocalTasksDataProvider.staticTasksData,
//            students = mutableListOf()
//        )

        val course = LocalCoursesDataProvider.getStaticCoursesData()[0]
        val filteredTasks = LocalTasksDataProvider.getStaticTasksData().filter { task: Task -> task.courseID == course.id }
        val currentTask = filteredTasks[0]
        val viewModel: TasksViewModel = viewModel()
        val navController = rememberNavController()

//        TaskDetailsScreen(task = currentTask, user = user, course = course, viewModel = viewModel)
//        TasksScreen(user = user, course = course)
        InfoPanelScreen(modifier = Modifier, user = user, tasksList = filteredTasks, navController = navController)
    }
}
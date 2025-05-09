package kz.narxoz.canvasdiplom.ui.theme.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
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
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.screens.Screen


@Composable
fun TaskDetailsScreen(
    navController: NavController,
    viewModel: TasksViewModel,
    task: Assignment,
    user: User,
    course: Course,
) {
//    val bottomNavController = rememberNavController()

//    Column {
//        BaseTopBar(
//            modifier = Modifier,
//            navController = navController,
//            task.title,
//            task.scores.find { it.studentId == user.id }?.grade,
////            previousScreen = {navController.popBackStack()} //viewModel.navigateToListPage(),
////            onClick = { navController.popBackStack() }
//        )
        CurrentTaskCard(task, user, course)
//        BaseBottomBar(bottomNavController, viewModel, Modifier)
//    }
}


@Composable
fun CurrentTaskCard(
    task: Assignment,
    user: User,
    course: Course,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
    ) {
        CurrentTaskCardInfo(task)
        
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            if (user.role == UserRole.STUDENT) {
                BaseButton(
                    buttonText = "Add File",
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                )

                Spacer(modifier = Modifier.width(16.dp))

                BaseButton(
                    buttonText = "Pass",
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                )
            } else if (user.role == UserRole.TEACHER){
                BaseButton(
                    buttonText = "Edit",
                    modifier = Modifier.weight(1f),
//                    onClick = {Screen.TaskEdit.createRoute(task.id)}
                )

                Spacer(modifier = Modifier.width(16.dp))

                BaseButton(
                    buttonText = "Publish",
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                )

                Spacer(modifier = Modifier.width(16.dp))

                BaseButton(
                    buttonText = "Check",
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}


@Composable
fun CurrentTaskCardInfo(
    task: Assignment
){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White),
//    ) {
        Text(text = task.title)
        Text(text = task.description)
//    }
    Row (
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ){
        Column (
            modifier = Modifier.weight(1f),
        ){
//            Text(text = "From:")
//            Text(text = task.startTime.toString())
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "To:")
            Text(text = task.dueDate.toString())
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TaskDetailsPreview() {
//    CanvasDiplomTheme {
//
//        val user = LocalUsersDataProvider.getUserByID(3) //S1
//
//        val course = LocalCoursesDataProvider.getStaticCoursesData()[0]
//        val filteredTasks = LocalTasksDataProvider.getStaticTasksData().filter { task: Task -> task.courseID == course.id }
//        val currentTask = filteredTasks[0]
//        val viewModel: TasksViewModel = viewModel()
//        val navController = rememberNavController()
//
//        TaskDetailsScreen(navController = navController, task = currentTask, user = user, course = course, viewModel = viewModel)
////        TasksScreen(user = user, course = course)
//    }
//}
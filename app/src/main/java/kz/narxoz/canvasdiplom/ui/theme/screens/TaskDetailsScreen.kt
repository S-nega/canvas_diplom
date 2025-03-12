package kz.narxoz.canvasdiplom.ui.theme.screens

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
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.TasksViewModel
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.BaseBottomBar
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar


@Composable
fun TaskDetailsScreen(
    viewModel: TasksViewModel,
    task: Task,
    user: User,
    course: Course,
) {
    Column {
        BaseTopBar(
            modifier = Modifier,
            task.title,
            task.scores.find { it.studentId == user.id }?.grade,
            previousScreen = viewModel.navigateToListPage()
        )
        CurrentTaskCard(task, user, course)
        BaseBottomBar(viewModel)
    }
}


@Composable
fun CurrentTaskCard(
    task: Task,
    user: User,
    course: Course,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Text(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                text = task.description
            )
        }
        Row (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ){
            Column (
                modifier = Modifier.weight(1f),
            ){
                Text(text = "From:")
                Text(text = task.startTime.toString())
            }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            Column (
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "To:")
                Text(text = task.deadline.toString())
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
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
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TaskDetailsPreview() {
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

        val course = Course(
            id = 1,
            title = "Android Development",
            teacher = User(
                id = "t1",
                name = "John",
                surname = "Doe",
                contact = "",
                email = "",
                login = "",
                password = "",
                role = UserRole.TEACHER,
                courses = mutableListOf()
            ),
            code = "ANDROID101",
            credits = 6,
            hoursPerWeek = 3,
            courseTable = mutableListOf(),
            tasks = LocalTasksDataProvider.staticTasksData,
            students = mutableListOf()
        )

        val filteredTasks = course.tasks
        val currentTask = filteredTasks[0]
        val viewModel: TasksViewModel = viewModel()

        TaskDetailsScreen(task = currentTask, user = user, course = course, viewModel = viewModel)
//        TasksScreen(user = user, course = course)
    }
}
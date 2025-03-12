package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
//    navController: NavController,
    user: User,
    course: Course
) {
    val viewModel: TasksViewModel = viewModel()

    Column {
        val isAbleAdding = user.role == UserRole.TEACHER
        val isAbleGrade = user.role == UserRole.STUDENT
//        BaseTopBar(course.title, isAbleAdding = isAbleAdding, isAbleGrade = isAbleGrade)

        val filteredTasks = course.tasks
        TasksList(user = user, filteredTasks = filteredTasks, course = course)

        BaseBottomBar(viewModel)
    }
}


@Composable
fun TaskDetailsScreen(
    viewModel: TasksViewModel,
    task: Task,
    user: User,
    course: Course,
) {
    Column {
//        val isAbleAdding = user.role == UserRole.TEACHER
//        val isAbleGrade = user.role == UserRole.STUDENT
        BaseTopBar(
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
//            {
//                Text(text = "Add file")
//            }
            Spacer(modifier = Modifier.width(16.dp))

            BaseButton(
                buttonText = "Pass",
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }
            )
        }
    }
}


@Composable
fun TasksList(
    viewModel: TasksViewModel = viewModel(),
    filteredTasks: List<Task>,
    user: User,
    course: Course,
) {
    LazyColumn(
        modifier = Modifier
//            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(filteredTasks) { task ->
            TaskCard(
                user = user,
                task = task,
                course = course,
                onClick = { viewModel.navigateToDetailPage() }
            )
        }
    }
}

@Composable
fun TaskCard(
    user: User,
    task: Task,
    course: Course,
    onClick: (Task) -> Unit
) {
    val grade = task.scores.find { it.studentId == user.id }?.grade


    Card(
        modifier = Modifier
            .padding(
                bottom = dimensionResource(id = R.dimen.padding_small)
            )
//            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Box(
                modifier = Modifier.weight(3f)
            ) {
                Column {
                    Text(
                        text = task.title,
                        style = Typography.titleMedium
                    )
                    Text(
                        text = task.description,
                        style = Typography.bodyMedium
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 2.dp, end = 2.dp, bottom = 2.dp)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = grade.toString(),
                    style = Typography.titleMedium
                )
            }
        }
    }
}


@Composable
fun CreateTaskScreen(
    user: User,
) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
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
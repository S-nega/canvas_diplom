package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    user: User,
    course: Course
) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text("Simple TopAppBar", maxLines = 1, overflow = TextOverflow.Ellipsis)
//                        },
//                navigationIcon = {
//                    IconButton(onClick = { /* doSomething() */ }) {
//                        Icon(
//                            imageVector = Icons.Default.KeyboardArrowLeft,
//                            contentDescription = "Localized description"
//                        )
//                    }
//                                 },
//                actions = {
//                    IconButton(onClick = { /* doSomething() */ }) {
//                        Icon(
//                            imageVector = Icons.Filled.Favorite,
//                            contentDescription = "Localized description"
//                        )
//                    }
//                }
//            )
//        },
//        content = { innerPadding -&gt;
//            LazyColumn(
//                contentPadding = innerPadding,
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                val list = (0..75).map { it.toString() }
//                items(count = list.size) {
//                    Text(
//                        text = list[it],
//                        style = MaterialTheme.typography.bodyLarge,
//                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
//                    )
//                }
//            }
//        } )

    Column {
        CanvasAppTopBar(course.title)

        val filteredTasks = course.tasks
        TasksList(user = user, filteredTasks = filteredTasks, course = course)

        CanvasAppBottomBar()
    }
}

//@Composable
//fun TopAppBar(){
//    Bar
//}

@Composable
fun BottomAppBar() {

}

@Composable
fun TasksList(
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
            TaskCard(user = user, task = task, course = course)
        }
    }
}

@Composable
fun TaskCard(
    user: User,
    task: Task,
    course: Course,
) {
    val grade = task.scores.find { it.studentId == user.id }?.grade

    Card(
        modifier = Modifier
            .padding(
                bottom = dimensionResource(id = R.dimen.padding_small)
            )
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

@Composable
fun ReadTaskScreen(
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
            role = UserRole.TEACHER,
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

        TasksScreen(user = user, course = course)
    }
}
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
import kz.narxoz.canvasdiplom.data.LocalAssignmentDataProvider
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Assignment
import kz.narxoz.canvasdiplom.models.AssignmentSubmission
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
    assignmentsList: List<Assignment>,
    navController: NavController
){
    val viewModel: TasksViewModel = viewModel()

    Column (
    ){
        InfoPanelDaysList(
            modifier = Modifier,
            user = user,
            assignmentsList = assignmentsList,
            navController = navController
        )
    }
}

@Composable
fun InfoPanelDaysList(
    modifier: Modifier,
    user: User,
    assignmentsList: List<Assignment>,
    navController: NavController
){
//    val userAssignments = LocalAssignmentDataProvider.getUserAssignmentsSortedByDeadline(user.id)
    InfoPanelTasksListInDay(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        user = user,
        day = LocalDateTime.of(2024, 2, 20, 0, 0),
        sortedAssignmentsList = assignmentsList, //userAssignments,
        navController = navController
    )
}

@Composable
fun InfoPanelTasksListInDay(
    modifier: Modifier,
    user: User,
    day: LocalDateTime,
    sortedAssignmentsList: List<Assignment>,
    navController: NavController,
    viewModel: TasksViewModel = viewModel(),
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
            items(sortedAssignmentsList) { assignment ->
                ListItem(
                    user = user,
                    title = assignment.title,
//                    title = LocalCoursesDataProvider.getCourseByID(assignment.assignmentGroupId).title.toString(),
                    description = assignment.description,
                    navController = navController,
                    route = Screen.TaskDetails.createRoute(assignment.id),
//                    onClick = { viewModel.navigateToDetailPage(user, assignment) }
                ){}
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun InfoPanelPreview() {
//    CanvasDiplomTheme {
//
//        val user = LocalUsersDataProvider.getUserByID(1)
//        val course = LocalCoursesDataProvider.getStaticCoursesData()[0]
//        val filteredTasks = LocalAssignmentDataProvider.getStaticAssignmentData().filter { assignment: Assignment -> assignment.assignmentGroupId == course.id }
//        val navController = rememberNavController()
//
//        InfoPanelScreen(modifier = Modifier, user = user, tasksList = filteredTasks, navController = navController)
//    }
//}
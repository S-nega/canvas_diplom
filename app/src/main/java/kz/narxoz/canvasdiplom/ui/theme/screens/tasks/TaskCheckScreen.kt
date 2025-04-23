package kz.narxoz.canvasdiplom.ui.theme.screens.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalAnswersDataProvider
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.TaskAnswer
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.components.ButtonStyles
import kz.narxoz.canvasdiplom.ui.theme.components.InputField


@Composable
fun TaskCheckScreen(
    task: Task,
    user: User // teacher id
){
    val answersList = LocalAnswersDataProvider.getAnswersByTaskID(task.id)
    var currentIndex by remember { mutableStateOf(0) }


    Column {
        CurrentTaskCardInfo(task)

        TaskCheckCard(answer = answersList[currentIndex])

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_medium))
        ) {
            BaseButton(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0,
                buttonText = "Previous",
                style = ButtonStyles.TINTED,
                modifier = Modifier.width(100.dp)
            )

            BaseButton(
                onClick = { if (currentIndex < answersList.size - 1) currentIndex++ },
                enabled = currentIndex < answersList.size - 1,
                buttonText = "Next",
                style = ButtonStyles.TINTED,
                modifier = Modifier.width(100.dp)
            )
        }


    }
}

@Composable
fun TaskCheckCard(
    answer: TaskAnswer,
){
    Card (
        modifier = Modifier.fillMaxWidth()
    ){
        val (grade, setGrade) = remember { mutableStateOf(TextFieldValue("")) }
        val (comment, setComment) = remember { mutableStateOf(TextFieldValue("")) }
        val currentStudent = LocalUsersDataProvider.getUserByID(answer.studentId)

        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        ) {

            Text(currentStudent.name + " " + currentStudent.surname)

            if (answer.fileUrl != null) {
                BaseButton(
                    onClick = { openFile(answer.fileUrl) },
                    style = ButtonStyles.TINTED,
                    buttonText = "Open file"
                )
            }
            Text(answer.textAnswer.toString())
//            Text(answer.comment.toString())
            
            InputField(
                text = grade,
                label = "Grade",
                onDisabledValueChanged = {}
            ) {
                setGrade(it)
            }

//            InputField(
//                text = comment,
//                label = "Comment",
//                onDisabledValueChanged = {}
//            ) {
//                setComment(it)
//            }
        }
    }
}

fun openFile(url: String) {
    // Implement logic to open the file or launch browser intent if needed
    println("Opening file: $url")
}

@Preview(showBackground = true)
@Composable
fun TaskCheckCardPreview() {
    CanvasDiplomTheme {
        val user = LocalUsersDataProvider.getUserByID("T2")
        val task = LocalTasksDataProvider.getTaskByID("L01")

//        TaskCheckCard(task = task, user = user)
        TaskCheckScreen(task = task, user = user)
    }
}
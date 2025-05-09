package kz.narxoz.canvasdiplom.ui.theme.screens.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalAnswersDataProvider
import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Assignment
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.components.ButtonStyles
import kz.narxoz.canvasdiplom.ui.theme.components.InputField

@Composable
fun TaskEditScreen( //Add
    task: Assignment? = null,
    user: User // teacher id
){
//    val answersList = task?.let { LocalAnswersDataProvider.getAnswersByTaskID(it.id) }
//    var currentIndex by remember { mutableIntStateOf(0) }
    val (title, setTitle) = remember { mutableStateOf(TextFieldValue(task?.title ?: "")) }
    val (description, setDesc) = remember { mutableStateOf(TextFieldValue(task?.description ?: "")) }
//    val (fromDate, setFromDate) = remember { mutableStateOf(task?.dueDate ?: "") }
    val (tillDate, setTillDate) = remember { mutableStateOf(task?.dueDate ?: "") }


    Column {
        InputField(
            text = title,
            label = "Title",
            onDisabledValueChanged = {}
        ) {
            setTitle(it)
        }

        InputField(
            text = description,
            label = "Description",
            onDisabledValueChanged = {}
        ) {
            setDesc(it)
        }
//
//        InputField(
//            text = fromDate,
//            label = "Able from date",
//            onDisabledValueChanged = {}
//        ) {
//            setFromDate(it)
//        }
//
//        InputField(
//            text = tillDate,
//            label = "Submit until date",
//            onDisabledValueChanged = {}
//        ) {
//            setTillDate(it)
//        }
//        CurrentTaskCardInfo(task)

//        TaskCheckCard(answer = answersList[currentIndex])

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_medium))
        ) {
            BaseButton(
                onClick = { }, //if (currentIndex > 0) currentIndex-- },
                enabled = task != null,
                buttonText = "Delete",
                style = ButtonStyles.TINTED,
                modifier = Modifier.width(100.dp)
            )

            BaseButton(
                onClick = { },//if (currentIndex < answersList.size - 1) currentIndex++ },
//                enabled = currentIndex < answersList.size - 1,
                buttonText = "Cancel",
                style = ButtonStyles.TINTED,
                modifier = Modifier.width(100.dp)
            )

            BaseButton(
                onClick = { },//if (currentIndex < answersList.size - 1) currentIndex++ },
//                enabled = currentIndex < answersList.size - 1,
                buttonText = "Save",
                style = ButtonStyles.TINTED,
                modifier = Modifier.width(100.dp)
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun TaskEditScreenPreview() {
    CanvasDiplomTheme {
        val user = LocalUsersDataProvider.getUserByID(3)
//        val task = LocalTasksDataProvider.getTaskByID("L01")

        TaskEditScreen( user = user)
    }
}
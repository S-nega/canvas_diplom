package kz.narxoz.canvasdiplom.models

import androidx.compose.ui.graphics.Color
import kz.narxoz.canvasdiplom.R

data class Hint( //event tags
//    val id: Int,
    val tag: String,
    val color: Int,
    val label: String
)
data class Events(
    val timeSlot: TimeSlot,
    val title: String,
    val room: String
)

enum class EventTags(
    val color: Color,
    val label: String
){
    EXAMS(
        color = Color.Red,
        label = "Exams day"
    ),
    REGISTRATION(
        color = Color.Green,
        label = "Registration is able"
    ),
    HOLIDAY(
        color = Color.Yellow,
        label = "Official day off"
    ),
    CONTROL(
        color = Color.Blue,
        label = "Intermediate knowledge control"
    )
}

var hintsList = mutableListOf<Hint>(
    Hint(
        tag = "exam",
        color = R.color.pink_exam,
        label = "Exams day"
    ),
    Hint(
        tag = "registration",
        color = R.color.green_reg,
        label = "Registration is able"
    ),
    Hint(
        tag = "holiday",
        color = R.color.yellow_holiday,
        label = "Official day off"
    ),
    Hint(
        tag = "control",
        color = R.color.blue_control,
        label = "Intermediate knowledge control"
    )
)
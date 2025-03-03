package kz.narxoz.canvasdiplom.models

import java.util.Date

data class Task(
    val id: Int,
    val title: String,
    val description: String,

    val startTime: Date,
    val deadline: Date,

    val createdAt: Date, // teacher created task
    val submittedAt: Date, // passedAt // student passed task

    val course: Course,
    val teacher: User,

    val scores: List<Scores>,
)

data class Scores(
    val studentId: String,
    val fileUrl: String,
    val grade: Double?
)
package kz.narxoz.canvasdiplom.models

import java.time.LocalDateTime

data class Task(
    val id: String, //MR001
    val title: String,
    val description: String,

    val startTime: LocalDateTime,
    val deadline: LocalDateTime,

    val createdAt: LocalDateTime, // teacher created task
    val submittedAt: LocalDateTime, // passedAt // student passed task

    val courseID: Int,
    val teacherID: String,

//    val scores: List<Scores>,
)

data class Scores(
    val studentId: String,
    val fileUrl: String,
    val grade: Double?
)

//data class Grade(
//    val studentId: String,
//    val taskId: String,
//
//)

data class TaskAnswer(
    val studentId: String,
    val taskId: String,

    val textAnswer: String?,
    val fileUrl: String?,

    val score: Int? = 0,
    val comment: String? = null
)


//fun findGrade(courseId: Int, taskId: Int, studentId: String): Double? {
//    val course = LocalCoursesDataProvider.getStaticCoursesData().find { it.id == courseId }
//
//    course ?: return null
//
//    val task = course.tasks.find { it.id == taskId }
//
//    task ?: return null
//
//    return task.scores.find { it.studentId == studentId }?.grade
//}

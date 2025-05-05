package kz.narxoz.canvasdiplom.models

import java.time.LocalDateTime
import java.util.Date

data class Attendance(
    val id: String, //??
    val courseID: Int,
    val teacherID: String,

    val dates: List<Date>,

    val studentsIds: List<String> //??
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

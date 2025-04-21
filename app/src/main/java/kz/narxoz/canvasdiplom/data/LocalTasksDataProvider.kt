package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.Scores
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import java.time.LocalDateTime

object LocalTasksDataProvider {

    var staticTasksData = mutableListOf<Task>(
        Task(
            id = 1,
            title = "Title1",
            description = "description1",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 1,
//            Course(
//                id = 1,
//                title = "Android Development",
//                teacher = User(id = "t1", name = "John", surname = "Doe", contact = "", email = "", login = "", password = "", role = UserRole.TEACHER, courses = mutableListOf()),
//                code = "ANDROID101",
//                credits = 6,
//                hoursPerWeek = 3,
//                courseTable = mutableListOf(),
//                tasks = mutableListOf(),
//                students = mutableListOf()
//            ),
            teacherID = "T2",
            scores = listOf(
                Scores(studentId = "S1", fileUrl = "https://example.com/submission1.pdf", grade = 85.5),
                Scores(studentId = "S2", fileUrl = "https://example.com/submission2.pdf", grade = 92.0),
                Scores(studentId = "S3", fileUrl = "https://example.com/submission3.pdf", grade = 67.0) // No grade yet
            )
        ),
        Task(
            id = 2,
            title = "Title2",
            description = "description2",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 1,
            teacherID = "T2",
            scores = listOf(
                Scores(studentId = "S1", fileUrl = "https://example.com/submission1.pdf", grade = 86.5),
                Scores(studentId = "S2", fileUrl = "https://example.com/submission2.pdf", grade = 91.0),
                Scores(studentId = "S3", fileUrl = "https://example.com/submission3.pdf", grade = 68.0) // No grade yet
            )
        ),
        Task(
            id = 3,
            title = "Title3",
            description = "description3",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 3,
            teacherID = "T2",
            scores = listOf(
                Scores(studentId = "S1", fileUrl = "https://example.com/submission1.pdf", grade = 84.5),
                Scores(studentId = "S2", fileUrl = "https://example.com/submission2.pdf", grade = 90.0),
                Scores(studentId = "S3", fileUrl = "https://example.com/submission3.pdf", grade = 66.0) // No grade yet
            )
        )
    )

//    fun getStaticTasksData(): List<Task> = staticTasksData

}
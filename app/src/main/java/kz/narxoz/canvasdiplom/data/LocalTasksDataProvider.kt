package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Scores
import kz.narxoz.canvasdiplom.models.Task
import java.time.LocalDateTime

object LocalTasksDataProvider {

    private var staticTasksData = mutableListOf<Task>(
        Task(
            id = "AD001",
            title = "Title1",
            description = "description1",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 1,
            teacherID = "T2",
        ),
        Task(
            id = "MD002",
            title = "Title2",
            description = "description2",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 1,
            teacherID = "T2",
        ),
        Task(
            id = "L01",
            title = "Title3",
            description = "description3",
            startTime = LocalDateTime.of(2025, 3, 2, 14, 30),
            deadline = LocalDateTime.of(2025, 3, 4, 14, 30),
            createdAt = LocalDateTime.of(2025, 3, 1, 14, 30),
            submittedAt = LocalDateTime.of(2025, 3, 3, 12,14),
            courseID = 3,
            teacherID = "T2",
        )
    )

    fun getStaticTasksData(): List<Task> = staticTasksData
    fun getTaskByID(taskId: String): Task =
        staticTasksData.find { task: Task -> task.id == taskId }!!


    fun getTasksByStudentID(studentId: String): List<Task> {
        val answers = LocalAnswersDataProvider.getAnswersByStudentID(studentId)
        val taskIdsWithAnswers = answers.map { it.taskId }.toSet()
        val tasksForStudent = staticTasksData.filter { it.id in taskIdsWithAnswers }
        return tasksForStudent
    }

}
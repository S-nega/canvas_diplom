package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Scores
import kz.narxoz.canvasdiplom.models.Task
import kz.narxoz.canvasdiplom.models.TaskAnswer

object LocalAnswersDataProvider {
    private var staticAnswersData = mutableListOf<TaskAnswer>(
        TaskAnswer(
            studentId = "S1",
            taskId = "L01",
            textAnswer = "answer l01",
            fileUrl = "https://example.com/bob_answer.pdf",
            score = 87,
            comment = "good"
        ),
        TaskAnswer(
            studentId = "S2",
            taskId = "L01",
            textAnswer = "answer l01 s2",
            fileUrl = null,
            score = 78,
            comment = ""
        ),
        TaskAnswer(
            studentId = "S1",
            taskId = "AD001",
            textAnswer = "answer ad01",
            fileUrl = null,
            score = 0,
            comment = "ok"
        )

    )

//    fun setScore(taskId: String, studentId: String, score: Int) {
//        LocalAnswersDataProvider.staticAnswersData.set(taskId, studentId, score)
//    } //file

    fun getStaticAnswersData(): List<TaskAnswer> = LocalAnswersDataProvider.staticAnswersData

    fun getAnswersByTaskID(taskId: String): List<TaskAnswer> =
        LocalAnswersDataProvider.staticAnswersData.filter { taskAnswer -> taskAnswer.taskId == taskId }

    fun getAnswersByStudentID(studentId: String): List<TaskAnswer> =
        LocalAnswersDataProvider.staticAnswersData.filter { taskAnswer -> taskAnswer.studentId == studentId }
}
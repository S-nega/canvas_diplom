//package kz.narxoz.canvasdiplom.viewModels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
//import kz.narxoz.canvasdiplom.models.TaskAnswer
//import kz.narxoz.canvasdiplom.models.User
//import kz.narxoz.canvasdiplom.models.UserRole
//
//// Sample data classes
////data class TaskAnswer(val textAnswer: String?, val fileUrl: String?)
//
//data class Grade(val score: Int, val comment: String)
//
//class TeacherViewModel : ViewModel() {
//    private val students = LocalUsersDataProvider.getStaticUsersData()
//        .find { user: User -> user.role == UserRole.STUDENT }
//
//
//
//    private val answers = mapOf(
//        Pair("S1", "task1") to TaskAnswer(textAnswer = "This is Alice's answer", fileUrl = null),
//        Pair("S2", "task1") to TaskAnswer(null, "https://example.com/bob_answer.pdf"),
//        Pair("S3", "task1") to TaskAnswer(null, null)
//    )
//
//    fun getStudentById(studentId: String): Student {
//        return students.find { it.id == studentId } ?: Student("", "Unknown")
//    }
//
//    fun getTaskAnswer(studentId: String, taskId: String): TaskAnswer {
//        return answers[Pair(studentId, taskId)] ?: TaskAnswer(null, null)
//    }
//
//    fun openFile(url: String) {
//        // Implement logic to open the file or launch browser intent if needed
//        println("Opening file: $url")
//    }
//
//    fun submitGrade(taskId: String, studentId: String, score: Int, comment: String) {
//        // Save to DB or backend
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                println("Submitting grade for student $studentId, task $taskId: $score%, comment: $comment")
//            }
//        }
//    }
//}
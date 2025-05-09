package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Assignment
import kz.narxoz.canvasdiplom.models.AssignmentGroup
import kz.narxoz.canvasdiplom.models.AssignmentSubmission
import kz.narxoz.canvasdiplom.models.Task
import java.sql.Timestamp

object LocalAssignmentDataProvider {

    private var staticAssignmentData = mutableListOf<Assignment>(
        Assignment(
            id = 1,
            weekId = 1,
            title = "task1",
            description = "task1 descr...",
            dueDate = Timestamp(System.currentTimeMillis()),
            maxPoints = 100,
            assignmentGroupId = 1,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        ),
        Assignment(
            id = 2,
            weekId = 1,
            title = "task2",
            description = "task2 descr...",
            dueDate = Timestamp(System.currentTimeMillis()),
            maxPoints = 100,
            assignmentGroupId = 1,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        ),
    )

    private var staticAssignmentGroupData = mutableListOf<AssignmentGroup>(
        AssignmentGroup(
            id = 1,
            threadId = 1,
            name = "Assignment group 1",
            groupType = "111",
            weight = 6,
            parentGroupId = 1,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        )
    )

    private var staticAssignmentSubmissionData = mutableListOf<AssignmentSubmission>(
        AssignmentSubmission(
            id = 1,
            assignmentId = 1,
            userId = 1,
            submittedAt = Timestamp(System.currentTimeMillis()),
            comment = "asd",
            score = 5.0,
            feedback = "asd",
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis())
        )
    )

    fun getStaticAssignmentData(): List<Assignment> = LocalAssignmentDataProvider.staticAssignmentData
    fun getAssignmentByID(assignmentId: Long): Assignment =
        LocalAssignmentDataProvider.staticAssignmentData.find { assignment: Assignment -> assignment.id == assignmentId }!!


    fun getAssignmentSubmissionByStudentID(studentId: Long): List<AssignmentSubmission> =
        LocalAssignmentDataProvider.staticAssignmentSubmissionData.filter { it.userId == studentId }

    fun getAssignmentSubmissionByAssignmentID(assignmentId: Long): List<AssignmentSubmission> =
        LocalAssignmentDataProvider.staticAssignmentSubmissionData.filter { it.assignmentId == assignmentId }

    fun getAssignmentsByStudentID(studentId: Long): List<Assignment> {
//        val answers = LocalAnswersDataProvider.getAnswersByStudentID(studentId)
        val assignmentSubmissions = LocalAssignmentDataProvider.getAssignmentSubmissionByStudentID(studentId)
        val assignmentIdsWithAnswers = assignmentSubmissions.map { it.assignmentId }.toSet()
        val assignmentsForStudent = LocalAssignmentDataProvider.staticAssignmentData.filter { it.id in assignmentIdsWithAnswers }
//            LocalTasksDataProvider.staticTasksData.filter { it.id in assignmentIdsWithAnswers }
        return assignmentsForStudent
    }

    fun getUserAssignmentsSortedByDeadline(currentUserId: Long): List<Assignment> {
        return getAssignmentsByStudentID(currentUserId).sortedBy { it.dueDate }
    }
}
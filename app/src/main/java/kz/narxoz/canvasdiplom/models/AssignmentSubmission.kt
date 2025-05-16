package kz.narxoz.canvasdiplom.models

import org.w3c.dom.Comment
import java.math.BigInteger
import java.sql.Timestamp

data class AssignmentSubmission (
    val id: Long,
    val assignmentId: Long,
    val userId: Long,
    val submittedAt: Timestamp,
    val fileUrls: List<String>? = null,
    val comment: String,
    val score: Double,
    val feedback: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class AssignmentAttachment (
    val id: Long,
    val assignmentId: Long,
    val fileUrl: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class AssignmentAttachment (
    val id: BigInteger,
    val assignmentId: BigInteger,
    val fileUrl: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
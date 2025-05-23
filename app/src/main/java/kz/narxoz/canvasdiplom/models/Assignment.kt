package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Assignment (
    val id: Long, //BigInteger,
    val weekId: Long,
    val title: String,
    val description: String,
    val dueDate: Timestamp,
    val maxPoints: Int,
    val assignmentGroupId: Long,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
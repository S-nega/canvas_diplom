package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Assignment (
    val id: BigInteger,
    val weekId: BigInteger,
    val title: String,
    val description: String,
    val dueDate: Timestamp,
    val maxPoints: Int,
    val assignmentGroupId: BigInteger,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
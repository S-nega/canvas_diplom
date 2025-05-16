package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Week (
    val id: Long,
    val threadId: Long,
    val weekNumber: Int,
    val type: String,
    val title: String,
    val description: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
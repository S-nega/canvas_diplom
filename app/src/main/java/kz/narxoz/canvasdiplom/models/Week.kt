package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Week (
    val id: BigInteger,
    val threadId: BigInteger,
    val weekNumber: Int,
    val type: String,
    val title: String,
    val description: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
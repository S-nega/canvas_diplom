package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp
import java.util.Date

data class Semester (
    val id: Long,
    val name: String,
    val startDate: Date,
    val endDate: Date,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
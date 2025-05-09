package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp
import java.util.Date

data class SemesterBreaks(
    val id: Long,
    val semesterId: Long,
    val breakDate: Date,
    val description: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
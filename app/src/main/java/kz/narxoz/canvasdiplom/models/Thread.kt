package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Thread(
    val id: Long,
    val courseId: Long,
    val semesterId: Long,
    val teacherId: Long,
    val title: String,
    val syllabusUrl: String,
    val maxStudents: Int,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
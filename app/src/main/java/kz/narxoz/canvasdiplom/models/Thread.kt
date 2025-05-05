package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Thread(
    val id: BigInteger,
    val courseId: BigInteger,
    val semesterId: BigInteger,
    val teacherId: BigInteger,
    val title: String,
    val syllabusUrl: String,
    val maxStudents: Int,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
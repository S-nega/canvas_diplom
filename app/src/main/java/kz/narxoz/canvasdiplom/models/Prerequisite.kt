package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Prerequisite(
    val courseId: Long,
    val prerequisiteCourseId: Long,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
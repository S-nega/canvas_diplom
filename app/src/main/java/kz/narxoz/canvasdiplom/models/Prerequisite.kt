package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class Prerequisite(
    val courseId: BigInteger,
    val prerequisiteCourseId: BigInteger,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
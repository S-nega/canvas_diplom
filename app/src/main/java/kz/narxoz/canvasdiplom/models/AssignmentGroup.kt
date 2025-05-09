package kz.narxoz.canvasdiplom.models

import android.icu.lang.UCharacter.NumericType
import java.math.BigDecimal
import java.math.BigInteger
import java.sql.Timestamp

data class AssignmentGroup (
    val id: Long,
    val threadId: Long,
    val name: String,
    val groupType: String, // add enum class
    val weight: Int, //BigDecimal, //NumericType, // ?? Number ??
    val parentGroupId: Long,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
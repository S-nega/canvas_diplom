package kz.narxoz.canvasdiplom.models

import android.icu.lang.UCharacter.NumericType
import java.math.BigInteger
import java.sql.Timestamp

data class AssignmentGroup (
    val id: BigInteger,
    val threadId: BigInteger,
    val name: String,
    val groupType: String,
    val weight: NumericType, // ?? Number ??
    val parentGroupId: BigInteger,

    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
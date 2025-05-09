package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class ThreadRegistration (
    val userId: Long,
    val threadId: Long,
    val registrationDate: Timestamp
)

package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp

data class ThreadRegistration (
    val userId: BigInteger,
    val threadId: BigInteger,
    val registrationDate: Timestamp
)

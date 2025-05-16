package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Timestamp
import java.util.UUID

data class User(
    val id: Long,
    val keycloakId: UUID? = null,
    val name: String,
    val surname: String,
    val email: String,
    val role: UserRole, //String
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val version: Int,

//    val id: String,
//    val login: String,
//    val password: String,
//    val contact: String,
//    val courses: List<Course>, // teachers courses too
)

enum class UserRole {
    ADMIN,
    MODERATOR,
    STUDENT,
    TEACHER
}
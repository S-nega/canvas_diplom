package kz.narxoz.canvasdiplom.models

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val contact: String,
    val email: String,
    val login: String,
    val password: String,
    val role: UserRole
)

enum class UserRole {
    ADMIN,
    MODERATOR,
    STUDENT,
    TEACHER
}
package kz.narxoz.canvasdiplom.models

data class User(
    val id: String,
    val name: String,
    val surname: String,
    val contact: String,
    val email: String,
    val login: String,
    val password: String,
    val role: UserRole,
    val courses: List<Course>, // teachers courses too
)

enum class UserRole {
    ADMIN,
    MODERATOR,
    STUDENT,
    TEACHER
}
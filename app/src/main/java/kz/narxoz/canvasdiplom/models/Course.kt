package kz.narxoz.canvasdiplom.models

data class Course (
    val id: Int,
    val title: String,
    val teacher: String,
    val code: String,
    val score: Int,
    val classRoom: String,
    val credits: Int,
    val isRegistered: Boolean? = false
)
package kz.narxoz.canvasdiplom.models

import java.math.BigInteger
import java.sql.Time
import java.sql.Timestamp
import java.util.Date

data class Course (
    val id: Long, //BigInteger,
    val title: String,

    val description: String,
    val bannerImageUrl: String,

    val createdAt: Timestamp,
    val updatedAt: Timestamp,

//    val code: String,
//    val credits: Int,
//    val hoursPerWeek: Int,
//
//    val studentsID: List<String>, //??
//    val teacherID: String,
//
//    val courseTable: List<CourseTable>
)

//
//data class CourseTable(
//    val weekDay: WeekDays,
//    val time: TimeSlot,
//    val room: Int // how to write all available ?
//
//)

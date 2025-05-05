package kz.narxoz.canvasdiplom.models

import java.sql.Time
import java.sql.Timestamp
import java.util.Date

data class Course (
    val id: Int,
    val title: String,

//    val description: String,
//    val bannerImageUrl: String,
//    val createdAt: Timestamp,
//    val updatedAt: Timestamp,


    val code: String,
    val credits: Int,
    val hoursPerWeek: Int,

    val studentsID: List<String>, //??
    val teacherID: String,

    val courseTable: List<CourseTable>





//    val students: List<User>,
//    val tasks: List<Task>,
    // there can be some days and rooms. It isn't one parameter
    // it would contain in timetable
//    val classRoom: String,
//    val dates: Date,
//    val isRegistered: Boolean? = false
)


data class CourseTable(
    val weekDay: WeekDays,
    val time: TimeSlot,
    val room: Int // how to write all available ?

)

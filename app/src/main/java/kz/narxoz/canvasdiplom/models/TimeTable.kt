package kz.narxoz.canvasdiplom.models

import java.util.Date

data class TimeTable(
    val startDay: Date,
    val endDay: Date,
    val examDays: List<Date>,
    val registrationDays: List<Date>,
)

enum class TimeSlot(val startTime: String, val endTime: String) {
    SLOT_1("08:00", "09:15"),
    SLOT_2("09:30", "10:45"),
    SLOT_3("11:00", "12:15"),
    SLOT_4("12:30", "13:45"),
    SLOT_5("14:00", "15:15"),
    SLOT_6("15:30", "16:45"),
    SLOT_7("17:00", "18:15"),
    SLOT_8("18:30", "19:45"),
    SLOT_9("20:00", "21:15");

    override fun toString(): String = "$startTime - $endTime"
}

enum class WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole

object LocalCoursesDataProvider {

    private var staticCoursesData = mutableListOf<Course>(
        Course(
            id = 1,
            title = "Android Development",
            teacherID = "T1",
            code = "ANDROID101",
            credits = 6,
            hoursPerWeek = 3,
            courseTable = mutableListOf(),
            studentsID = mutableListOf("s1", "s2", "s4")
        ),
        Course(
            id = 2,
            title = "Cisco",
            teacherID = "T2",
            code = "CISCO",
            credits = 6,
            hoursPerWeek = 3,
            courseTable = mutableListOf(),
            studentsID = mutableListOf("s1", "s3", "s4")
        ),
        Course(
            id = 3,
            title = "Linux",
            teacherID = "T3",
            code = "LINUX",
            credits = 6,
            hoursPerWeek = 3,
            courseTable = mutableListOf(),
            studentsID = mutableListOf("s3", "s2", "s4")
        ),
    )

    fun getStaticCoursesData(): List<Course> = staticCoursesData

    fun getCourseByID(courseId: Int): Course =
        staticCoursesData.find { course -> course.id == courseId }!!

}

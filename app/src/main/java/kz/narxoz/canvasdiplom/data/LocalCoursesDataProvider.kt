package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole

object LocalCoursesDataProvider {

    private var staticCoursesData = mutableListOf<Course>(
        Course(
            id = 1,
            title = "Mobile Developing",
            teacher = LocalUsersDataProvider.getStaticUsersData().first { it.role == UserRole.TEACHER },
            code = "MD4",
//            score = 0,
//            classRoom = "GUK 412",
            credits = 6,
            hoursPerWeek = 3,
            students = LocalUsersDataProvider.getStaticUsersData(),
            tasks = mutableListOf(),
            courseTable = mutableListOf()
        ),
        Course(
            id = 1,
            title = "Mobile Developing",
            teacher = LocalUsersDataProvider.getStaticUsersData().first { it.role == UserRole.TEACHER },
            code = "MD4",
//            score = 0,
//            classRoom = "GUK 412",
            credits = 6,
            hoursPerWeek = 3,
            students = LocalUsersDataProvider.getStaticUsersData(),
            tasks = mutableListOf(),
            courseTable = mutableListOf()
        ),
        Course(
            id = 1,
            title = "Mobile Developing",
            teacher = LocalUsersDataProvider.getStaticUsersData().first { it.role == UserRole.TEACHER },
            code = "MD4",
//            score = 0,
//            classRoom = "GUK 412",
            credits = 6,
            hoursPerWeek = 3,
            students = LocalUsersDataProvider.getStaticUsersData(),
            tasks = mutableListOf(),
            courseTable = mutableListOf()
        )
    )

    fun getStaticCoursesData(): List<Course> = staticCoursesData
}

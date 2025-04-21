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
//            User(
//                id = "t1",
//                name = "John",
//                surname = "Doe",
//                contact = "",
//                email = "",
//                login = "",
//                password = "",
//                role = UserRole.TEACHER,
//                courses = mutableListOf()
//            ),
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
            teacherID = "t3",
            code = "LINUX",
            credits = 6,
            hoursPerWeek = 3,
            courseTable = mutableListOf(),
            studentsID = mutableListOf("s3", "s2", "s4")
        ),

//            studentsID = LocalUsersDataProvider.getStaticUsersData().filter { user: User -> user.courses == id }
//            tasks = LocalTasksDataProvider.staticTasksData.filter { task -> task.course.id == id },
//            students = mutableListOf()
//        ),
//        Course(
//            id = 2,
//            title = "Linux",
//            teacher = User(
//                id = "t2",
//                name = "Linux teacher",
//                surname = "Doe",
//                contact = "",
//                email = "",
//                login = "",
//                password = "",
//                role = UserRole.TEACHER,
//                courses = mutableListOf()
//            ),
//            code = "LINUX101",
//            credits = 6,
//            hoursPerWeek = 3,
//            courseTable = mutableListOf(),
//            tasks = LocalTasksDataProvider.staticTasksData,
//            students = mutableListOf()
//        ),
//        Course(
//            id = 3,
//            title = "Cisco",
//            teacher = User(
//                id = "t3",
//                name = "cisco teacher",
//                surname = "Doe",
//                contact = "",
//                email = "",
//                login = "",
//                password = "",
//                role = UserRole.TEACHER,
//                courses = mutableListOf()
//            ),
//            code = "CISCO101",
//            credits = 6,
//            hoursPerWeek = 3,
//            courseTable = mutableListOf(),
//            tasks = LocalTasksDataProvider.staticTasksData,
//            students = mutableListOf()
//        )
    )

    fun getStaticCoursesData(): List<Course> = staticCoursesData

    fun getCourseByID(courseId: Int): Course =
        staticCoursesData.find { course -> course.id == courseId }!!

}

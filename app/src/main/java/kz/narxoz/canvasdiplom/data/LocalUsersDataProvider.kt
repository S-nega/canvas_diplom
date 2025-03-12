package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole

object LocalUsersDataProvider {

    private var staticUsersData = mutableListOf<User>(
        User(
            id = "S1",
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.STUDENT,
            courses = LocalCoursesDataProvider.getStaticCoursesData()
        ),
        User(
            id = "S2",
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.TEACHER,
            courses = LocalCoursesDataProvider.getStaticCoursesData()
        ),
        User(
            id = "S3",
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.MODERATOR,
            courses = LocalCoursesDataProvider.getStaticCoursesData()
        )
    )

    fun getStaticUsersData(): List<User> = LocalUsersDataProvider.staticUsersData

}
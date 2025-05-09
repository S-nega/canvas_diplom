package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import java.sql.Timestamp

object LocalUsersDataProvider {

    private var staticUsersData = mutableListOf<User>(
        User(
            id = 1,
            name = "Snega",
            surname = "Golovko",
            email = "snezhana@gmail.com",
            role = UserRole.STUDENT,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis()),
            version = 1
        ),
        User(
            id = 2,
            name = "222",
            surname = "222",
            email = "222@gmail.com",
            role = UserRole.STUDENT,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis()),
            version = 2
        ),
        User(
            id = 3,
            name = "333",
            surname = "333",
            email = "333@gmail.com",
            role = UserRole.TEACHER,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis()),
            version = 1
        ),
        User(
            id = 4,
            name = "444",
            surname = "444",
            email = "444@gmail.com",
            role = UserRole.TEACHER,
            createdAt = Timestamp(System.currentTimeMillis()),
            updatedAt = Timestamp(System.currentTimeMillis()),
            version = 2
        ),
//        User(
//            id = "S2",
//            name = "2222",
//            surname = "222",
//            contact = "+77077446255",
//            email = "snezhana.golovko@narxoz.kz",
//            login = "s23016985",
//            password = "qweqwe",
//            role = UserRole.STUDENT,
//            courses = LocalCoursesDataProvider.getStaticCoursesData()
//        ),
//        User(
//            id = "T2",
//            name = "TEACHER",
//            surname = "Golovko",
//            contact = "+77077446255",
//            email = "snezhana.golovko@narxoz.kz",
//            login = "s23016985",
//            password = "qweqwe",
//            role = UserRole.TEACHER,
//            courses = LocalCoursesDataProvider.getStaticCoursesData()
//        ),
//        User(
//            id = "M3",
//            name = "Snezhana",
//            surname = "Golovko",
//            contact = "+77077446255",
//            email = "snezhana.golovko@narxoz.kz",
//            login = "s23016985",
//            password = "qweqwe",
//            role = UserRole.MODERATOR,
//            courses = LocalCoursesDataProvider.getStaticCoursesData()
//        )
    )

    fun getStaticUsersData(): List<User> = staticUsersData

    fun getUserByID(userId: Long): User =
        staticUsersData.find { user: User -> user.id == userId }!!

}
package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole

object LocalUsersDataProvider {

    private var staticUsersData = mutableListOf<User>(
        User(
            id = 1,
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.STUDENT
        ),
        User(
            id = 2,
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.TEACHER
        ),
        User(
            id = 3,
            name = "Snezhana",
            surname = "Golovko",
            contact = "+77077446255",
            email = "snezhana.golovko@narxoz.kz",
            login = "s23016985",
            password = "qweqwe",
            role = UserRole.MODERATOR
        )
    )

    fun getStaticUsersData(): List<User> = LocalUsersDataProvider.staticUsersData

}
package kz.narxoz.canvasdiplom.data

import kz.narxoz.canvasdiplom.models.Course

object LocalCoursesDataProvider {

    private var staticCoursesData = mutableListOf<Course>(
        Course(
            id = 1,
            title = "Mobile Developing",
            teacher = "Agay",
            code = "MD4",
            score = 0,
            classRoom = "GUK 412",
            credits = 6,
            isRegistered = false
        ),
        Course(
            id = 2,
            title = "CISCO",
            teacher = "Agay",
            code = "C3",
            score = 0,
            classRoom = "GUK 512",
            credits = 7,
            isRegistered = false
        ),
        Course(
            id = 3,
            title = "Linux",
            teacher = "Agay",
            code = "OSL4",
            score = 0,
            classRoom = "GUK 501",
            credits = 7,
            isRegistered = true
        )
    )

    fun getStaticCoursesData(): List<Course> = staticCoursesData
}

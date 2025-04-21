//package kz.narxoz.canvasdiplom.ui.theme.screens
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
//import kz.narxoz.canvasdiplom.models.Course
//import kz.narxoz.canvasdiplom.models.TimeTable
//import kz.narxoz.canvasdiplom.models.User
//import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
//import kz.narxoz.canvasdiplom.ui.theme.components.InputField
//import java.sql.Time
//import java.time.LocalDateTime
//
//@Composable
//fun CourseRegistrationScreen(
//    modifier: Modifier,
//    user: User,
//    courseList: List<Course>,
//    timeTable: TimeTable
//){
//    Column {
//        InputField(text = TextFieldValue("Search")) {
//        }
//        DaysList(courseList, timeTable)
//        BaseButton(buttonText = "Register")
//    }
//}
//
//@Composable
//fun DaysList(
//    courseList: List<Course>,
//    timeTable: TimeTable
//){
//    LazyColumn {
//        items(timeTable) {day ->
//            Text(text = day.toString())// weekday's name
//            TimesList()
//        }
//    }
//}
//
//@Composable
//fun TimesList(){
//    LazyColumn {
//        items(times) {time ->
//            TimeCard(time)
//        }
//    }
//}
//
//@Composable
//fun TimeCard(
//    courseList: List<Course>,
//    time: Time,
//){
//    Card {
//        Row {
//            Text(text = time.toString()) // 12.00-13.15
//
//            CoursesRegList(courseList = courseList)
//        }
//    }
//}
//
//@Composable
//fun CoursesRegList(
//    courseList: List<Course>
//){
//    LazyColumn {
//        items(courseList) {course ->
//            CourseRegItem(course)
//        }
//    }
//}
//
//@Composable
//fun CourseRegItem(
//    course: Course
//){
//    Row {
//        Column {
//            Text(text = course.title)
//            Text(text = course.id.toString())
//            Text(text = LocalUsersDataProvider.getUserByID(course.teacherID).toString())
//            Text(text = course.credits.toString())
////            Text(text = course.courseTable.room)
//        }
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = "Add Course to my list"
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewCourseRegistrationScreen () {
//    CourseRegistrationScreen(modifier = Modifier)
//}

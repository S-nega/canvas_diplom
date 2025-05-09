package kz.narxoz.canvasdiplom.ui.theme.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.User


@Composable
fun AttendanceCheckScreen(
    user: User, //teacher
    course: Course
){
//    if (user.id == course.teacherID) {
//        val student = LocalUsersDataProvider.getUserByID(studentId)
//        AttendanceTable(students = course.studentsID, dates =, attendance = )
//    }
//    LazyColumn {
//        items(course.studentsID) { studentId ->
//            Row {
//                val student = LocalUsersDataProvider.getUserByID(studentId)
//                Text(text = student.name + student.surname)
//            }
//
//        }
//    }
}

@Composable
fun AttendanceTable(
    students: List<String>,
    dates: List<String>,
    attendance: Map<String, List<String>>
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White),
//        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Header Row
            Row {
                Text(
                    text = "Student Name",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium
                )
                dates.forEach { date ->
                    Text(
                        text = date,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Divider(modifier = Modifier.padding(vertical = 4.dp))

            // Students Rows
            students.forEach { student ->
                Row(
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        text = student,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodySmall
                    )
                    attendance[student]?.forEach { status ->
                        Text(
                            text = status,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendancePreview(){
    AttendanceCheckScreen(user = LocalUsersDataProvider.getUserByID(1), course = LocalCoursesDataProvider.getCourseByID(2))
}
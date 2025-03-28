package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.models.Course

@Composable
fun CoursesScreen(
    modifier: Modifier,
    courses: List<Course>,
){

    LazyColumn(modifier = modifier){
        items(courses, key = {course -> course.id}) { course ->
            CourseCard(
                course = course
            )
        }
    }
}

@Composable
fun CourseCard(
    course: Course
) {
    Box {
        Row {
            Column {
                Text(text = course.title)
                Text(text = course.teacher.name + " " + course.teacher.surname)
            }
//            Text(text = course.tasks)
        }
    }
}

@Composable
fun CourseRegistrationScreen(
    modifier: Modifier
){

}

@Composable
fun RegisteredCoursesScreen(
    modifier: Modifier
){

}

@Composable
fun IndividualStudyPlanScreen(
    modifier: Modifier
){

}








@Composable
fun CoursesTopBar(
    modifier: Modifier
){
    Box(modifier = Modifier){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "back") // change to icon later
        }
        Text(text = "Screen Title") // variable
    }
}

@Composable
fun CoursesBottomBar(
    modifier: Modifier
){ // may be it's better to give courses links to origin BottomBar ???
    Box(modifier = Modifier){
        IconButton(onClick = { /*OPEN PROFILE SCREEN*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Profile"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Info Panel"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Calendar"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Courses"
            )
        }
    }
}
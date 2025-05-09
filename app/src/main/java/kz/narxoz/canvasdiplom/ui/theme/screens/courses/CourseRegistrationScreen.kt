package kz.narxoz.canvasdiplom.ui.theme.screens.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalCoursesDataProvider
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.Course
import kz.narxoz.canvasdiplom.models.TimeSlot
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.WeekDays
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.components.InputField

@Composable
fun CourseRegistrationScreen(
    modifier: Modifier,
    user: User,
    courseList: List<Course>,
//    weekDays: WeekDays,
//    timeSlot: TimeSlot
){
    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState) // Добавлен скролл
        ) {
//            InputField(text = TextFieldValue("Search")) {}
            SearchAndFiltersSection()

            DaysList(courseList)

    //        TimesList()
    //        CoursesRegList(courseList = courseList)
//            BaseButton(buttonText = "Register")
        }
        BaseButton(
            buttonText = "Register",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun SearchAndFiltersSection() {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var selectedCourse by remember { mutableStateOf<String?>(null) }
    var selectedSemester by remember { mutableStateOf<String?>(null) }
    var selectedSpecialty by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Поле для поиска
        InputField(
            text = searchText,
            onValueChanged = { searchText = it },
            label = "Search Courses" //.toString() //Text("Search Courses") }
        )

//        Spacer(modifier = Modifier.height(16.dp))

        // Фильтры
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            // Фильтр по курсу
            DropdownFilter(
                label = "Study Year",
                selectedItem = selectedCourse,
                items = listOf("Year 1", "Year 2", "Year 3"),
                onItemSelected = { selectedCourse = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Фильтр по семестру
            DropdownFilter(
                label = "Semester",
                selectedItem = selectedSemester,
                items = listOf("Semester 1", "Semester 2"),
                onItemSelected = { selectedSemester = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Фильтр по специальности
            DropdownFilter(
                label = "Specialty",
                selectedItem = selectedSpecialty,
                items = listOf("Computer Science", "Engineering", "Design"),
                onItemSelected = { selectedSpecialty = it },
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun <T> DropdownFilter(
    modifier: Modifier,
    label: String,
    selectedItem: T?,
    items: List<T>,
    onItemSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    // Нужно для ExposedDropdownMenuBox
    val selectedText = selectedItem?.toString() ?: ""

    Box(modifier = modifier) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            // Этот TextField автоматически связывается с выпадающим меню
            TextField(
                value = selectedText,
                onValueChange = {}, // поле только для отображения
                readOnly = true,
                label = { Text(label) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor() // очень важно!
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item.toString()) },
                        onClick = {
                            onItemSelected(item)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun DaysList(
    courseList: List<Course>,
//    timeTable: TimeTable
){
    val weekDays = WeekDays.entries.toTypedArray()
    Column {
        weekDays.forEach { day ->
            Text(text = day.toString()) // Название дня недели
            TimesList()
        }
    }
}

@Composable
fun TimesList() {
    val timeSlots = TimeSlot.entries
    val grayColor = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0)) // Светло-серый
    val whiteColor = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7))

    Column {
        timeSlots.forEachIndexed { index, time ->
            val color = if (index % 2 == 0) grayColor else whiteColor
            TimeCard(time = time, color = color)
        }
    }
}

@Composable
fun TimeCard(
//    courseList: List<Course>,
    time: TimeSlot,
    color: CardColors
){
    Card (
        colors = color
    ){
        Row (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
//                .background(color = color)
        ){
            Text(text = time.toString())
            val courseList = LocalCoursesDataProvider.getStaticCoursesData()
            CoursesRegList(courseList = courseList)
        }
    }
}

@Composable
fun CoursesRegList(
    courseList: List<Course> // get only available courses
){
    Column {
        courseList.forEach { course ->
            CourseRegItem(course)
        }
    }
//    LazyColumn (
//        modifier = Modifier.fillMaxSize()
//    ){
//        items(courseList) { course ->
//            CourseRegItem(course)
//        }
//    }
}

@Composable
fun CourseRegItem(
    course: Course
){
    Row (
        modifier = Modifier
            .padding(start = dimensionResource(id = R.dimen.padding_small))
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(text = course.title)
            Text(text = course.description)
//            Text(text = course.id.toString())
//            Text(text = LocalUsersDataProvider.getUserByID(course.teacherID).toString())
//            Text(text = course.weight.toString())
//            Text(text = course.courseTable.room)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Course to my list"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCourseRegistrationScreen () {
    val user = LocalUsersDataProvider.getUserByID(1)
    val courseList = LocalCoursesDataProvider.getStaticCoursesData()
//    val timeTable = ()

    CourseRegistrationScreen(modifier = Modifier, user = user, courseList = courseList )
}

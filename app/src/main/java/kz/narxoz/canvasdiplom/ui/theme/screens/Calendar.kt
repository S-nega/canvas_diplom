package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.models.Hint
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.ui.theme.components.BaseBottomBar
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalendarScreen(
    modifier: Modifier,
    navController: NavController
){
    val viewModel: TasksViewModel = viewModel()
//    val bottomNavController = rememberNavController()

    val currentDate = LocalDate.now()
    val yearMonth = YearMonth.of(currentDate.year, currentDate.month)
//    val daysInMonth = yearMonth.lengthOfMonth()
//
//    val firstDayOfMonth = LocalDate.of(currentDate.year, currentDate.month, 1)
//    val dayOfWeek = firstDayOfMonth.dayOfWeek.value // 1 = Monday, 7 = Sunday
//
//    val daysList = List(dayOfWeek - 1) { null } + (1..daysInMonth).toList()

    Column {
        BaseTopBar(modifier = modifier, navController = navController, title = "Calendar")

        CalendarCard(yearMonth)
        EventsCard()

//        BaseBottomBar(bottomNavController, viewModel, modifier)
    }
}

@Composable
fun CalendarCard(
    yearMonth: YearMonth
){
//    var month = "March"//preview

//    var hintsList = remember {
//        listOf(
//            id = 1, color = Color.Blue,
//        )
//    }
    Card {
        Column {
            CalendarTopBar(yearMonth)
            Divider()
            CalendarGrid(yearMonth)
            Divider()
//            CalendarHints(hintsList = hintsList)
        }
    }
}

@Composable
fun CalendarTopBar(
    yearMonth: YearMonth
){
    Row (
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Previous Month"
            )
        }

        Text(
            text = yearMonth.toString(),
            style = Typography.titleMedium
        )

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Next Month"
            )
        }
    }
}

@Composable
fun CalendarGrid(
    yearMonth: YearMonth
){
    val currentDate = LocalDate.now()
//    val yearMonth = YearMonth.of(currentDate.year, currentDate.month)
    val daysInMonth = yearMonth.lengthOfMonth()

    val firstDayOfMonth = LocalDate.of(currentDate.year, currentDate.month, 1)
    val dayOfWeek = firstDayOfMonth.dayOfWeek.value // 1 = Monday, 7 = Sunday

    val daysList = List(dayOfWeek - 1) { null } + (1..daysInMonth).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(7), // 7 columns for the week
        modifier = Modifier,
//            .padding(R.dimen.padding_medium),
//            .padding(R.dimen.padding_medium),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(daysList) { day ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = day?.toString() ?: "") // Empty spaces for alignment
            }
        }
    }
}

@Composable
fun CalendarItem(
    day: String,
    color: Color? = Color.Transparent
){
    Card (
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.padding_large))
            .background(color!!)
    ){
        Text(text = day)
    }
}

@Composable
fun CalendarHints(
    hintsList: List<Hint>
){
    LazyColumn {
        items(hintsList) {hint ->
            HintItem(color = hint.color, hint = hint.text )
        }
    }
}

@Composable
fun HintItem(
    color: Color,
    hint: String
){
    Row(){
        Card (
            modifier = Modifier
                .background(color)
        ) {}
        Text(text = hint)
    }
}

@Composable
fun EventsCard(

){

}

@Preview(showBackground = true)
@Composable
fun CalendarPreview(){
    CanvasDiplomTheme {
        CalendarScreen(modifier = Modifier, navController = rememberNavController())
    }
}
package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.ui.theme.screens.Screen
import java.util.Date

//
//@Composable
//fun BaseTopBar(title: String, navController: NavController) {
//    TopAppBar(
//        title = { Text(text = title) },
//        navigationIcon = {
//            if (navController.previousBackStackEntry != null) {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
//                }
//            }
//        },
//        actions = {
//            IconButton(onClick = { /* TODO: Add action */ }) {
//                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
//            }
//        }
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar( // change the way of calculating data
//    modifier: Modifier,
    navController: NavController,
    title: String,
    grade: Double? = null,
    deadLine: Date? = null,

    previousScreen: Unit? = null, //(() -> Unit?)? = null, //
    nextScreen: Unit? = null,

    onClick: (() -> Unit?)? = null
){

    val canPopBack = navController.previousBackStackEntry != null

    TopAppBar(
//        modifier = modifier,
        title = { Text(text = title, style = Typography.titleLarge) },
        navigationIcon = {
            if (canPopBack) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
//            previousScreen?.let {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowLeft,
//                        contentDescription = "Back"
//                    )
//                }
//            }
        },
        actions = {
            when {
                nextScreen != null -> {
                    IconButton(onClick = { nextScreen }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }
                grade != null -> {
                    Text(
                        text = grade.toString(),
                        modifier = Modifier.padding(
                            end = dimensionResource(
                                id = R.dimen.padding_medium)
                        )
                    )
                }
                deadLine != null -> {
                    Text(
                        text = deadLine.toString(),
                        modifier = Modifier.padding(
                            end = dimensionResource(
                                id = R.dimen.padding_medium)
                        )
                    )
                }
            }
        }
    )
}


@Composable
fun BaseBottomBar(
    navController: NavController,
    viewModel: TasksViewModel,
    modifier: Modifier
) {
    val items = listOf(
        Screen.Profile,
        Screen.Calendar,
        Screen.Courses,
        Screen.InfoPanel
    )

//    BottomNavigation {
//        val navBackStackEntry = navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry.value?.destination?.route
//
//        items.forEach { screen ->
//            BottomNavigationItem(
//                icon = { Icon(Icons.Default.Home, contentDescription = screen.route) },
//                label = { Text(screen.route.capitalize()) },
//                selected = currentRoute == screen.route,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.startDestinationId) { saveState = true }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }


    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        BaseBottomBarIconButton(
            imageVector = Icons.Default.AccountCircle,
            label = "Profile",
            onClick = {viewModel.navigateToAddPage()}
        )
        BaseBottomBarIconButton(
            imageVector = Icons.Default.Notifications,
            label = "Info panel",
            onClick = {viewModel.navigateToAddPage()}
        )
        BaseBottomBarIconButton(
            imageVector = Icons.Default.DateRange,
            label = "Calendar",
            onClick = {viewModel.navigateToAddPage()}
        )
        BaseBottomBarIconButton(
            imageVector = Icons.Default.List,
            label = "Courses",
            onClick = {viewModel.navigateToAddPage()}
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(Screen.Profile, Screen.InfoPanel, Screen.Calendar, Screen.Courses)
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { screen.icon?.let { Icon(it, contentDescription = screen.label) } },
                label = { screen.label?.let { Text(it) } },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



@Composable
fun BaseBottomBarIconButton(
    imageVector: ImageVector,
    label: String,
    onClick: () -> Unit
){
    IconButton(
        modifier = Modifier
            .width(64.dp),
        onClick = { onClick }
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                imageVector = imageVector,
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = label
            )
            Text(
                text = label,
                style = Typography.bodySmall
            )
        }
    }
}

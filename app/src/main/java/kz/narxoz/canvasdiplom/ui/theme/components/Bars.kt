package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.ui.theme.screens.Screen
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar(
    // change the way of calculating data
//    modifier: Modifier,
    navController: NavController,
    title: String,
    grade: Double? = null,
    deadLine: Date? = null,

//    previousScreen: Unit? = null, //(() -> Unit?)? = null, //
    nextScreen: Unit? = null,

    onClick: (() -> Unit?)? = null,
) {

    val canPopBack = navController.previousBackStackEntry != null

    TopAppBar(
        title = { Text(text = title, style = Typography.titleLarge) },
        navigationIcon = {
            if (canPopBack) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
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
                                id = R.dimen.padding_medium
                            )
                        )
                    )
                }

                deadLine != null -> {
                    Text(
                        text = deadLine.toString(),
                        modifier = Modifier.padding(
                            end = dimensionResource(
                                id = R.dimen.padding_medium
                            )
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
    modifier: Modifier,
) {
    val items = listOf(
        Screen.Profile,
        Screen.Calendar,
        Screen.Courses,
        Screen.Info
    )
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
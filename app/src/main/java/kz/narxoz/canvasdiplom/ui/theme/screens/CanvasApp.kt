package kz.narxoz.canvasdiplom.ui.theme.screens

import android.content.Context
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography
import java.util.Date

@Composable
fun CanvasApp(
//    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    context: Context
){
    val context = LocalContext.current

    val viewModel: TasksViewModel = viewModel()
//    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        AuthorizationScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun AuthorizationScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Canvas Logo"
        )
        Text(text = "text input Login")
        Text(text = "text input Password")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Enter")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Forgot Password?")
        }
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier,
//    user: User
) {
    Column {
        Text(text = "Name Surname")
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "User Photo" 
        )
        Text(text = "Contact")
        Text(text = "Biography")
        Text(text = "Links")
    }
}

@Composable
fun InfoPanelScreen(
    modifier: Modifier
){

}

@Composable
fun CalendarScreen(
    modifier: Modifier
){

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar( // change the way of calculating data
    title: String,
    grade: Double? = null,
    deadLine: Date? = null,

    previousScreen: Unit? = null,
    nextScreen: Unit? = null,
){
    TopAppBar(
        title = { Text(text = title, style = Typography.titleLarge) },
        navigationIcon = {
            previousScreen?.let {
                IconButton(onClick = { it }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
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

//    Row(
//        modifier = Modifier
//            .padding(dimensionResource(id = R.dimen.padding_medium))
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ){
//        Row (
//            modifier = Modifier,
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ){
//
//            if (previousScreen != null) {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowLeft,
//                        contentDescription = "back"
//                    )
//                }
//            }
//            Text(
//                text = title,
//                style = Typography.titleLarge
//            )
//        }
//
//        if (nextScreen != null) {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Add"
//                )
//            }
//        } else if (grade != null){
//            Text(text = grade.toString())
//        } else if (deadLine != null){
//            Text(text = deadLine.toString())
//        }
//    }
}

@Composable
fun BaseBottomBar(
    viewModel: TasksViewModel
) {
    Row(
        modifier = Modifier
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
        Column {
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CanvasAppBottomBarPreview() {
    CanvasDiplomTheme {
//        val windowSize = calculateWindowSizeClass(this)
        val context = LocalContext.current
        CanvasApp(
            context = context,
//            windowSize = windowSize.widthSizeClass,
        )

    }
}

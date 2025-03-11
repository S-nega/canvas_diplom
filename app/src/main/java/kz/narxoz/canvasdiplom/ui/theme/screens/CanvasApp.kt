package kz.narxoz.canvasdiplom.ui.theme.screens

import android.content.Context
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.TasksViewModel
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.Calendar

@Composable
fun CanvasApp(
//    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
//    context: Context
){
//    val viewModel: TasksViewModel = viewModel()
//    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
//            CanvasAppTopBar("Canvas")
        },
        bottomBar = {
            CanvasAppBottomBar()
        }
    ) { innerPadding ->
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


@Composable
fun CanvasAppTopBar(
    title: String,
//    currentUser: User,
    isMainPage: Boolean? = false, // may be it's better to get Back-Page and if it is we show back-icon ??
    isAbleAdding: Boolean? = false,
){ // does we need it?
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (!isMainPage!!) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back"
                    )
                }
            }
            Text(
                text = title,
                style = Typography.titleLarge
            )
        }
        if (isAbleAdding!!) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
//        Text(text = "+")// only in Courses block
    }
}

@Composable
fun CanvasAppBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        IconButton(onClick = { /*OPEN PROFILE SCREEN*/ }) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Notifications,
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Info Panel"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.DateRange,
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Calendar"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.List,
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Courses"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CanvasAppBottomBarPreview() {
    CanvasDiplomTheme {
        CanvasApp(modifier = Modifier)
    }
}

package kz.narxoz.canvasdiplom.ui.theme.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kz.narxoz.canvasdiplom.R
import java.util.Calendar

@Composable
fun CanvasApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    context: Context
){
//    val viewModel: SportsViewModel = viewModel()
//    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CanvasAppTopBar()
        },
        bottomBar = {
            CanvasAppBottomBar()
        }
    ) { innerPadding ->
        AuthorizationScreen(
            modifier = Modifier
            .padding(innerPadding)
        )
    }
}

@Composable
fun AuthorizationScreen(
    modifier: Modifier
) {
    Column {
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
fun CanvasAppTopBar(){ // does we need it?
    Box(modifier = Modifier){
        Text(text = "Screen Name")
        Text(text = "+")// only in Courses block
    }
}

@Composable
fun CanvasAppBottomBar() {
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

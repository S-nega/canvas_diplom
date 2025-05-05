package kz.narxoz.canvasdiplom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import kz.narxoz.canvasdiplom.ui.theme.screens.AppNavigation
import kz.narxoz.canvasdiplom.ui.theme.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            AppNavigation()
        }
    }
}

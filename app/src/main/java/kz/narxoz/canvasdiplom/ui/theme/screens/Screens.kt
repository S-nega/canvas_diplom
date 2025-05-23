package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector?, val label: String?) {
    object Profile : Screen("profile", Icons.Default.AccountCircle, "Profile")
    object Info : Screen("info", Icons.Default.Notifications, "Info")
    object Calendar : Screen("calendar", Icons.Default.DateRange, "Calendar")
    object Courses : Screen("courses", Icons.Default.List, "Courses")
    object Tasks : Screen("tasks", Icons.Default.List, "Tasks")
    object TaskDetails : Screen("task_details/{taskId}", Icons.Default.Info, "Task's Details") {
        fun createRoute(taskId: Long) = "task_details/$taskId"
    }
    object TaskEdit : Screen("task_edit/{taskId}", Icons.Default.Info, "Edit Task") {
        fun createRoute(taskId: String) = "task_edit/$taskId"
    }
}
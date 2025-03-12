package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.Typography
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar( // change the way of calculating data
    modifier: Modifier,
    title: String,
    grade: Double? = null,
    deadLine: Date? = null,

    previousScreen: Unit? = null,
    nextScreen: Unit? = null,
){
    TopAppBar(
        modifier = modifier,
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
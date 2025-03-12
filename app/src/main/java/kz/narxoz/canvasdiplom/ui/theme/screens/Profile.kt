package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.TasksViewModel
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.ui.theme.components.BaseBottomBar
import kz.narxoz.canvasdiplom.ui.theme.components.BaseTopBar


@Composable
fun ProfileScreen(
    modifier: Modifier,
    user: User,
    viewModel: TasksViewModel
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(
            modifier = modifier
                .background(color = colorResource(id = R.color.red)),
            title = "Profile",
        )

        Header(user, modifier)
        InfoBlock(user)

        BaseBottomBar(viewModel = viewModel)
    }
}

@Composable
fun Header(
    user: User,
    modifier: Modifier
){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = user.name + " " + user.surname,
            style = Typography.titleLarge
        )
        Icon(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "User Photo"
        )
    }
}

@Composable
fun InfoBlock(
    user: User
){
    Column (
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ){
        Text(text = "id: " + user.id)
        Text(text = "Contact: " + user.contact)
        Text(text = "Email: " + user.email)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    CanvasDiplomTheme {
        val context = LocalContext.current
        val viewModel: TasksViewModel = viewModel()

        val user = User(
            id = "S1",
            name = "John",
            surname = "Doe",
            contact = "+1234567890",
            email = "john.doe@example.com",
            login = "jdoe",
            password = "securepassword",
            role = UserRole.STUDENT,
            courses = mutableListOf()
        )

        ProfileScreen(
            modifier = Modifier,
            user = user,
            viewModel = viewModel
        )

    }
}
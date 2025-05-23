package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.data.LocalUsersDataProvider
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.models.UserRole
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.Typography
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel


@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavController,
    user: User,
    viewModel: TasksViewModel
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(user, modifier)
        InfoBlock(user)
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
        Text(text = "Email: " + user.email)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    CanvasDiplomTheme {
        val viewModel: TasksViewModel = viewModel()

        val user = LocalUsersDataProvider.getUserByID(1)

        ProfileScreen(
            modifier = Modifier,
            user = user,
            viewModel = viewModel,
            navController = rememberNavController()
        )

    }
}
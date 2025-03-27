package kz.narxoz.canvasdiplom.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.viewModels.TasksViewModel
import kz.narxoz.canvasdiplom.ui.theme.CanvasDiplomTheme
import kz.narxoz.canvasdiplom.ui.theme.components.BaseButton
import kz.narxoz.canvasdiplom.ui.theme.components.ButtonSizes
import kz.narxoz.canvasdiplom.ui.theme.components.ButtonStyles
import kz.narxoz.canvasdiplom.ui.theme.components.InputField


@Composable
fun AuthorizationScreen(
    modifier: Modifier,
    viewModel: TasksViewModel,
//    onAuthorized: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val (login, setLogin) = remember { mutableStateOf(TextFieldValue("")) }
        val (password, setPassword) = remember { mutableStateOf(TextFieldValue("")) }

        Column (
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Canvas Logo"
            )

            InputField(
                text = login,
                label = "Login",
                onDisabledValueChanged = {}
            ) {
                setLogin(it)
            }
            InputField(
                text = password,
                label = "Password",
                supportingText = "Password or Login incorrect",
                onDisabledValueChanged = {}
            ) {
                setPassword(it)
            }
            BaseButton(
                modifier = Modifier.fillMaxWidth(),
                size = ButtonSizes.L,
                onClick = { viewModel.navigateToListPage() },
                buttonText = "Enter"
            )
            BaseButton(
                onClick = { viewModel.navigateToListPage() },
                buttonText = "Forgot Password?",
                style = ButtonStyles.TEXT_BUTTON
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthorization() {
    CanvasDiplomTheme {
        val context = LocalContext.current
        val viewModel: TasksViewModel = viewModel()

        AuthorizationScreen(
            modifier = Modifier,
            viewModel = viewModel,
//            onAuthorized = {
//                navController.navigate(Screen.Main.route) {
//                    popUpTo(Screen.Auth.route) { inclusive = true }
//            }
        )

    }
}
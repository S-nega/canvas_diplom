package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.models.User
import kz.narxoz.canvasdiplom.ui.theme.Typography

@Composable
fun ListItem(
    user: User,
    title: String,
    description: String,
    grade: Double? = null,
    navController: NavController,
    route: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(
                bottom = dimensionResource(id = R.dimen.padding_small)
            )
            .clickable {
                navController.navigate( route )
            }
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Box(
                modifier = Modifier.weight(3f)
            ) {
                Column {
                    Text(
                        text = title,
                        style = Typography.titleMedium
                    )
                    Text(
                        text = description,
                        style = Typography.bodyMedium
                    )
                }
            }

            if (grade != null) {
                Box(
                    modifier = Modifier
                        .padding(top = 2.dp, end = 2.dp, bottom = 2.dp)
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = grade.toString(),
                        style = Typography.titleMedium
                    )
                }
            }
        }
    }
}
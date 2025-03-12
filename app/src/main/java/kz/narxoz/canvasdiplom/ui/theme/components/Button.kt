package kz.narxoz.canvasdiplom.ui.theme.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kz.narxoz.canvasdiplom.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    backgroundColor: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = colorResource(id = R.color.red),
        contentColor = colorResource(id = R.color.gray_25),
        disabledContainerColor = colorResource(id = R.color.inko_25),
        disabledContentColor = colorResource(id = R.color.mezo_20)
    ),
    buttonText: String = "",
    enabled: Boolean = true,
    isRounded: Boolean = false,
    size: ButtonSizes? = null,
    style: ButtonStyles? = null,
    onClick: (() -> Unit)? = null
) {

    val buttonParameters = GetButtonParameters(
        size,
        style,
        isRounded,
        backgroundColor
    )

    Button(
        modifier = modifier
            .shadow(
                elevation = buttonParameters.shadowElevation,
                shape = RoundedCornerShape(buttonParameters.cornerRadius),
                spotColor = colorResource(id = R.color.inko_25),
                clip = false
            )
            .height(buttonParameters.height),
        shape = RoundedCornerShape(buttonParameters.cornerRadius),
        colors = buttonParameters.buttonColors,
        contentPadding = buttonParameters.padding,
        enabled = enabled,
        onClick = {
            onClick?.invoke()
        }
    ) {
        Text(
            modifier = Modifier,
            textAlign = TextAlign.Center,
            text = if (size == ButtonSizes.XS) buttonText else buttonText.uppercase(),
            style = buttonParameters.textStyle
        )
    }
}

@Composable
fun BaseDebouncedButton(
    modifier: Modifier = Modifier,
    backgroundColor: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = colorResource(id = R.color.red),
        contentColor = colorResource(id = R.color.gray_75)
    ),
    buttonText: String = "",
    enabled: Boolean = true,
    isRounded: Boolean = false,
    size: ButtonSizes? = null,
    style: ButtonStyles? = null,
    onClick: (() -> Unit)? = null
) {
    val coroutineScope = rememberCoroutineScope()
    var isClickable by remember { mutableStateOf(true) }

    BaseButton(
        modifier = modifier,
        backgroundColor = backgroundColor,
        buttonText = buttonText,
        enabled = enabled,
        size = size,
        style = style,
        isRounded = isRounded,
        onClick = {
            if (isClickable) {
                onClick?.invoke()
                isClickable = false
                coroutineScope.launch {
                    delay(0)
                    isClickable = true
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun BaseButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        BaseButton(
            style = ButtonStyles.FILLED,
            size = ButtonSizes.M,
            isRounded = false,
            enabled = true,
            buttonText = "Base Button"
        )

        BaseDebouncedButton(
            buttonText = "Debounced Button"
        )
    }
}

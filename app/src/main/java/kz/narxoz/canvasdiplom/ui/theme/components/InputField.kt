package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    text: TextFieldValue,
    label: String? = null,
    supportingText: String? = null,
    enabled: Boolean = true,
    maxLength: Int = 20,
    singleLine: Boolean = true,
    inputType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onDisabledValueChanged: (() -> Unit)? = null,
    onValueChanged: (text: TextFieldValue) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val borderColor = if (isFocused) {
        colorResource(id = R.color.purple_700)
    } else {
        colorResource(id = R.color.purple_500)
    }

    val colors = TextFieldDefaults.colors(
        focusedTextColor = colorResource(id = R.color.gray_75),
        unfocusedTextColor = colorResource(id = R.color.gray_75),
        disabledTextColor = colorResource(id = R.color.gray_50),
        focusedLabelColor = colorResource(id = R.color.gray_50),
        unfocusedLabelColor = colorResource(id = R.color.gray_50),
        disabledLabelColor = colorResource(id = R.color.purple_200),
        cursorColor = colorResource(id = R.color.gray_50),
        focusedContainerColor = colorResource(id = R.color.gray_25),
        unfocusedContainerColor = colorResource(id = R.color.gray_25),
        disabledContainerColor = colorResource(id = R.color.gray_25),
        focusedIndicatorColor = colorResource(id = R.color.white),
        unfocusedIndicatorColor = colorResource(id = R.color.white)
    )

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, borderColor, shape = RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                label = {
                    label?.let {
                        Text(
                            text = it
                        )
                    }
                },
                onValueChange = {
                    if (it.text.length <= maxLength) {
                        onValueChanged(it)
                    }
                },
                singleLine = singleLine,
//                textStyle = ,
                enabled = enabled,
                isError = isError,
                visualTransformation = visualTransformation,
                keyboardOptions = KeyboardOptions(
                    keyboardType = inputType,
                    imeAction = imeAction
                ),
                interactionSource = interactionSource,
                shape = RoundedCornerShape(8.dp),
                colors = colors
            )
        }
        if (supportingText != null) {
            Text(
                text = supportingText,
//                style = captionStyle,
                color = colorResource(id = R.color.red),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp)
            )
        }
    }

    LaunchedEffect(text) {
        onDisabledValueChanged?.invoke()
    }
}

@Preview
@Composable
private fun InputFieldPreview() {
    val (autoPrice, setAutoPrice) = remember { mutableStateOf(TextFieldValue("s00000000")) }
    InputField(
        modifier = Modifier
            .padding(top = 16.dp),
        text = autoPrice,
        label = "Login",
        supportingText = "Error",
        onDisabledValueChanged = {}
    ) {
        setAutoPrice(it)
    }
}

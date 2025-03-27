package kz.narxoz.canvasdiplom.ui.theme.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kz.narxoz.canvasdiplom.R
import kz.narxoz.canvasdiplom.ui.theme.body2MediumTextStyle
import kz.narxoz.canvasdiplom.ui.theme.buttonLTextStyle
import kz.narxoz.canvasdiplom.ui.theme.buttonMTextStyle
import kz.narxoz.canvasdiplom.ui.theme.buttonSTextStyle
import kz.narxoz.canvasdiplom.ui.theme.buttonXLTextStyle

data class ButtonParameters(
    val cornerRadius: Dp,
    val height: Dp,
    val padding: PaddingValues,
    val textStyle: TextStyle,
    val shadowElevation: Dp,
    val tonalElevation: Dp,
    val buttonColors: ButtonColors
)

@Composable
fun GetButtonParameters(
    size: ButtonSizes?,
    style: ButtonStyles?,
    isRounded: Boolean,
    buttonColors: ButtonColors
): ButtonParameters {

    val height = when {
        style == ButtonStyles.TEXT_BUTTON -> if (size == ButtonSizes.XS) 20.dp else 16.dp
        size != null -> size.buttonHeight
        else -> ButtonSizes.M.buttonHeight
    }
    val padding: PaddingValues = when {
        style == ButtonStyles.TEXT_BUTTON -> PaddingValues(0.dp)
        size != null -> size.buttonPadding
        else -> ButtonSizes.M.buttonPadding
    }
    val cornerRadius = when {
        style == ButtonStyles.TEXT_BUTTON -> 0.dp
        !isRounded -> 8.dp
        size != null -> size.cornerRadius
        else -> 8.dp
    }

    val shadowElevation = if (style == ButtonStyles.ELEVATED) 16.dp else 0.dp
    val tonalElevation = if (style == ButtonStyles.ELEVATED) 2.dp else 0.dp

    val textStyle = size?.textStyle.let { buttonMTextStyle }

    val contentColor = when {
        style != null -> colorResource(id = style.textColor)
        else -> buttonColors.contentColor
    }
    val disabledContentColor = colorResource(id = R.color.gray_25)

    val containerColor = when {
        style != null -> colorResource(id = style.backgroundColor)
        else -> buttonColors.containerColor
    }
    val disabledContainerColor = when (style) {
        ButtonStyles.TEXT_BUTTON, ButtonStyles.PLAIN -> colorResource(id = R.color.transparent)
        ButtonStyles.FILLED, ButtonStyles.TINTED, null -> colorResource(id = R.color.mezo_20)
        else -> colorResource(id = style.backgroundColor)
    }

    return ButtonParameters(
        textStyle = textStyle,
        cornerRadius = cornerRadius,
        height = height,
        padding = padding,
        shadowElevation = shadowElevation,
        tonalElevation = tonalElevation,
        buttonColors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    )
}

enum class ButtonStyles(
    val backgroundColor: Int,
    val textColor: Int
) {
    FILLED(
        backgroundColor = R.color.red,
        textColor = R.color.gray_25
    ),
    TINTED(
        backgroundColor = R.color.red_15,
        textColor = R.color.red
    ),
    ELEVATED(
        backgroundColor = R.color.papera_80,
        textColor = R.color.inko_100
    ),
    PLAIN(
        backgroundColor = R.color.transparent,
        textColor = R.color.red
    ),
    TEXT_BUTTON(
        backgroundColor = R.color.transparent,
        textColor = R.color.red
    )
}

enum class ButtonSizes(
    val cornerRadius: Dp,
    val buttonHeight: Dp,
    val buttonPadding: PaddingValues,
    val textStyle: TextStyle
) {
    XS(
        cornerRadius = 16.dp,
        buttonHeight = 24.dp,
        PaddingValues(8.dp, 4.dp),
        textStyle = body2MediumTextStyle
    ),
    S(
        cornerRadius = 16.dp,
        buttonHeight = 32.dp,
        PaddingValues(12.dp, 8.dp),
        textStyle = buttonSTextStyle
    ),
    M(
        cornerRadius = 20.dp,
        buttonHeight = 40.dp,
        PaddingValues(16.dp, 12.dp),
        textStyle = buttonMTextStyle
    ),
    L(
        cornerRadius = 24.dp,
        buttonHeight = 48.dp,
        PaddingValues(20.dp, 16.dp),
        textStyle = buttonLTextStyle
    ),
    XL(
        cornerRadius = 28.dp,
        buttonHeight = 56.dp,
//        PaddingValues(12.dp, 8.dp),
        PaddingValues(24.dp, 20.dp),
        textStyle = buttonXLTextStyle
    );
}
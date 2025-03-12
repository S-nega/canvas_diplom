package kz.narxoz.canvasdiplom.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextDecoration
import kz.narxoz.canvasdiplom.R


//private val oktaNeueBold = FontFamily(
//    Font(R.font.okta_neue_bold)
//)
//
//private val oktaNeueRegular = FontFamily(
//    Font(R.font.okta_neue_regular)
//)
//
//private val interRegular = FontFamily(
//    Font(R.font.inter_regular)
//)
//
//private val interMedium = FontFamily(
//    Font(R.font.inter_medium)
//)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    )
)


val titleH5TextStyle = TextStyle(
//    fontFamily = oktaNeueBold,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 32.sp
)

val titleH6TextStyle = TextStyle(
//    fontFamily = oktaNeueBold,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp
)

val body1RegularTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val body1BoldTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val body2RegularTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

val body2MediumTextStyle = TextStyle(
//    fontFamily = interMedium,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

val body3RegularTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

val body3BoldTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 16.sp
)


val body3BoldTextStyleLineThrough = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    textDecoration = TextDecoration.LineThrough
)

val body4RegularTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 12.sp
)

val body4BoldTextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.Bold,
    fontSize = 10.sp,
    lineHeight = 16.sp
)

val subtitle1TextStyle = TextStyle(
//    fontFamily = oktaNeueBold,
    fontSize = 20.sp,
    lineHeight = 24.sp
)

val subtitle2TextStyle = TextStyle(
//    fontFamily = oktaNeueBold,
    fontSize = 17.sp,
    lineHeight = 20.sp
)

val subtitle3TextStyle = TextStyle(
//    fontFamily = oktaNeueBold,
    fontSize = 13.sp,
    lineHeight = 26.sp
)

val button1TextStyle = TextStyle(
//    fontFamily = interRegular,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 16.sp
)

val captionStyle = TextStyle(
//    fontFamily = interMedium,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

val oktaNeueSmallTextStyleLineThrough = TextStyle(
//    fontFamily = oktaNeueRegular,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    textDecoration = TextDecoration.LineThrough
)


package com.whysoezzy.bia_ui.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.whysoezzy.bia_ui.R

val stolzl = FontFamily(
    Font(R.font.stolzl_light, FontWeight.Light),
    Font(R.font.stolzl_bold, FontWeight.Bold),
    Font(R.font.stolzl_regular, FontWeight.Normal),
    Font(R.font.stolzl_medium, FontWeight.Medium),
    Font(R.font.stolzl_thin, FontWeight.Thin),
    Font(R.font.stolzl_book, FontWeight.ExtraLight)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = stolzl,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.LightGray
    ),
    bodySmall = TextStyle(
        fontFamily = stolzl,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.LightGray
    ),
    headlineSmall = TextStyle(
        fontFamily = stolzl,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black
    ),
    headlineLarge = TextStyle(
        fontFamily = stolzl,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = stolzl,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 14.sp
    )

)
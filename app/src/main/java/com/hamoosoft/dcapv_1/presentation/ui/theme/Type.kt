package com.hamoosoft.dcapv_1.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hamoosoft.dcapv_1.R

// Set of Material typography styles to start with
val robotoFonts =
    FontFamily(
        Font(R.font.roboto_bold),
        Font(R.font.roboto_extra_bold),
        Font(R.font.roboto_extra_light),
        Font(R.font.roboto_light),
        Font(R.font.roboto_medium),
        Font(R.font.roboto_regular),
        Font(R.font.roboto_regular),
        Font(R.font.roboto_semi_bold),
        Font(R.font.roboto_thin)
    )
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ), titleLarge = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ), titleMedium = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ), titleSmall = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ), labelLarge = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ), labelSmall = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
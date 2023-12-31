package com.hamoosoft.dcapv_1.presentation.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    small = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    medium = CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp),
    large = RoundedCornerShape(
        topStart = 10.dp,
        topEnd = 30.dp,
        bottomStart = 30.dp,
        bottomEnd = 10.dp
    ),
)
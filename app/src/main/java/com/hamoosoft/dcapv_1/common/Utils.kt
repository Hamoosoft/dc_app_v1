package com.hamoosoft.dcapv_1.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import com.hamoosoft.dcapv_1.navigation.Routes

object Utils {
    val bottomNavItems = listOf(
        Icons.Default.Home to Routes.Home.name,
        Icons.Default.Info to Routes.About.name,
        Icons.Default.Settings to Routes.Settings.name
    )
}
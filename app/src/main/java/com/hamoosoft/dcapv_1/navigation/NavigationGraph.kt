package com.hamoosoft.dcapv_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hamoosoft.dcapv_1.presentation.screens.about.AboutScreen
import com.hamoosoft.dcapv_1.presentation.screens.home.HomeScreen
import com.hamoosoft.dcapv_1.presentation.screens.settings.SettingsScreen
import com.hamoosoft.dcapv_1.presentation.screens.splash.SplashScreen

@Composable
fun DcAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.name) {
        composable(route = Routes.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(route = Routes.Home.name) {
            HomeScreen(navController = navController)
        }
        composable(route = Routes.Settings.name) {
            SettingsScreen(navController = navController)
        }
        composable(route = Routes.About.name) {
            AboutScreen(navController = navController)
        }
    }
}
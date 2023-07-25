package com.hamoosoft.dcapv_1.presentation.screens.home

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.hamoosoft.dcapv_1.navigation.Routes
import com.hamoosoft.dcapv_1.presentation.screens.home.home_components.DcAppTopBar
import com.hamoosoft.dcapv_1.presentation.screens.home.home_components.HomeNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navController: NavController) {
    val exitApp = LocalContext.current as Activity
    val selectedItem = rememberSaveable {
        mutableStateOf(Routes.Home.name)

    }
    Scaffold(topBar = { DcAppTopBar(onExitAppIconClick = { exitApp.finish() }) }, bottomBar = {
        HomeNavigation(
            selectedItem = selectedItem.value,
            onItemClick = {
                selectedItem.value = it
                if (it != Routes.Home.name) navController.navigate(it)
            }
        )
    }) {
        HomeScreenContent(modifier = Modifier.padding(it))


    }
}

@Composable
fun HomeScreenContent(modifier: Modifier) {

}


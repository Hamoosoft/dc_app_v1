package com.hamoosoft.dcapv_1.presentation.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hamoosoft.dcapv_1.navigation.Routes
import com.hamoosoft.dcapv_1.presentation.screens.home.home_components.DcAppTopBar
import com.hamoosoft.dcapv_1.presentation.screens.home.home_components.HomeNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    var selectedItem = rememberSaveable {
        mutableStateOf(Routes.Settings.name)

    }
    Scaffold(
        topBar = {
            DcAppTopBar(
                isHome = false,
                navigateBackOrMenuIconClick = { navController.popBackStack() },
                title = Routes.Settings.name
            )
        },
        bottomBar = {
            HomeNavigation(
                selectedItem = selectedItem.value,
                onItemClick = {
                    selectedItem.value = it
                    if (it != Routes.Settings.name) navController.navigate(
                        it
                    )
                })
        }) {
        SettingsContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun SettingsContent(modifier: Modifier) {
    Column() {

    }

}

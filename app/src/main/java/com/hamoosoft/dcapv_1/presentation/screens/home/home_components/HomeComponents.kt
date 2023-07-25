package com.hamoosoft.dcapv_1.presentation.screens.home.home_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hamoosoft.dcapv_1.R
import com.hamoosoft.dcapv_1.common.Utils

@Composable
fun DcAppTopBar(
    title: String = "DcHome",
    isHome: Boolean = true,
    onExitAppIconClick: () -> Unit = {},
    navigateBackOrMenuIconClick: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxWidth(), shadowElevation = 6.dp, shape = RectangleShape) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { navigateBackOrMenuIconClick.invoke() }) {
                Icon(
                    painter = if (isHome) painterResource(id = R.drawable.baseline_menu) else painterResource(
                        id = R.drawable.dc
                    ),
                    contentDescription = "back",
                    modifier = Modifier.size(50.dp),
                    tint = if (isHome) MaterialTheme.colorScheme.primary else Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.padding(start = 25.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.weight(1f))
            if (isHome) {
                IconButton(onClick = { onExitAppIconClick.invoke() }) {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = "back", tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(end = 10.dp))
                }
            }

        }
    }
}


@Composable
fun HomeNavigation(
    items: List<Pair<ImageVector, String>> = Utils.bottomNavItems, selectedItem: String,
    onItemClick: (String) -> Unit
) {
    NavigationBar() {
        items.forEach {
            NavigationBarItem(
                selected = it.second == selectedItem,
                onClick = { onItemClick(it.second) },
                icon = {
                    Icon(
                        imageVector = it.first,
                        contentDescription = it.second,
                        tint = MaterialTheme.colorScheme.primary.copy(0.5f)
                    )
                },
                label = {
                    Text(
                        text = it.second,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                })
        }

    }
}
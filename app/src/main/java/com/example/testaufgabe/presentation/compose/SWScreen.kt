package com.example.testaufgabe.presentation.compose

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testaufgabe.domain.model.SwapiResourceType
import com.example.testaufgabe.presentation.navigation.drawerDestinations
import kotlinx.coroutines.launch

@Composable
fun SWScreen(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selected by remember { mutableStateOf(SwapiResourceType.PEOPLE) }

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                drawerDestinations.forEach { dest ->
                    NavigationDrawerItem(
                        label = { Text(dest.label) },
                        selected = dest.type == selected,
                        onClick = {
                            selected = dest.type
                            coroutineScope.launch { drawerState.close() }
                        },
                        icon = { Icon(dest.icon, contentDescription = dest.label) }
                    )
                }
            }
        }
    ) {
        SWListScreen(
            resourceType = selected,
            onMenuClick = {
                coroutineScope.launch { drawerState.open() }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SWScreenPreview() {
    SWScreen(
        modifier = Modifier
    )
}

package com.example.testaufgabe.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testaufgabe.domain.model.SwapiResourceType

data class DrawerDestination(
    val type: SwapiResourceType,
    val label: String,
    val icon: ImageVector
)

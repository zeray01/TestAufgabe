package com.example.testaufgabe.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Rocket
import com.example.testaufgabe.domain.model.SwapiResourceType


val drawerDestinations = listOf(
    DrawerDestination(SwapiResourceType.PEOPLE, "People", Icons.Filled.Person),
    DrawerDestination(SwapiResourceType.PLANETS, "Planets", Icons.Filled.Public),
    DrawerDestination(SwapiResourceType.FILMS, "Films", Icons.Filled.Movie),
    DrawerDestination(SwapiResourceType.SPECIES, "Species", Icons.Filled.Man),
    DrawerDestination(SwapiResourceType.VEHICLES, "Vehicles", Icons.Filled.DirectionsCar),
    DrawerDestination(SwapiResourceType.STARSHIPS, "Starships", Icons.Filled.Rocket)
)

package com.montilivi.navigationcompose2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow

object NavigationBarItems
{
	val Items = listOf(
		NavigationBarItem("Choose user", Icons.Filled.Add, Destination.ChooseUser.route),
		NavigationBarItem("Play", Icons.Filled.PlayArrow, Destination.Game.route),
	)
}
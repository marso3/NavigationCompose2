package com.montilivi.navigationcompose2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayArrow

object NavigationDrawerItems
{
	val Items = listOf(
		NavigationDrawerItem(
			"Choose user",
			Icons.Outlined.Add,
			Icons.Filled.Add,
			Destination.ChooseUser.route
		),
		NavigationDrawerItem(
			"Play",
			Icons.Outlined.PlayArrow,
			Icons.Filled.PlayArrow,
			Destination.Game.route
		)
	)
}
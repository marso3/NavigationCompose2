package com.montilivi.navigationcompose2.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(
	val title: String,
	val image: ImageVector,
	val selectedImage: ImageVector,
	val route: String)
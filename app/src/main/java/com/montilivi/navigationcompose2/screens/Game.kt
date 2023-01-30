package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.montilivi.navigationcompose2.navigation.navigateToGameLost
import com.montilivi.navigationcompose2.navigation.navigateToGameWon

@Composable
fun GameScreen(navController: NavController) {
	Column() {
		Spacer(modifier = Modifier.weight(1f))
		Button(onClick = { navigateToGameWon(navController) }, Modifier.fillMaxWidth()) {
			Text(text = "Win")
		}
		Spacer(modifier = Modifier.weight(0.5f))
		Button(onClick = { navigateToGameLost(navController) }, Modifier.fillMaxWidth()) {
			Text(text = "Lose")
		}
		Spacer(modifier = Modifier.weight(1f))
	}
}
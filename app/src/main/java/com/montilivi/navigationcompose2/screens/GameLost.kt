package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.montilivi.navigationcompose2.R
import com.montilivi.navigationcompose2.navigation.navigateBack

@Composable
fun GameLostScreen(navController: NavController) {
	Column() {
		Image(painter = painterResource(id = R.drawable.you_lose), contentDescription = null)
		Text(text = "No has aconseguit prou puntuació per arribar a estar entre els millors")
		Spacer(modifier = Modifier.weight(1f))
		Button(onClick = { navigateBack(navController) }, Modifier.fillMaxWidth()) {
			Text(text = "Play again")
		}
		Spacer(modifier = Modifier.weight(1f))
	}
}
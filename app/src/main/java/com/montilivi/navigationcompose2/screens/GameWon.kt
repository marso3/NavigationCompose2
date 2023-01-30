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
import com.montilivi.navigationcompose2.navigation.navigateToRanking

@Composable
fun GameWonScreen(navController: NavController) {
	Column() {
		Image(painter = painterResource(id = R.drawable.you_win), contentDescription = null)
		Text(text = "Has entrat dins les millors puntuacions")
		Spacer(modifier = Modifier.weight(1f))
		Button(onClick = { navigateBack(navController) }, Modifier.fillMaxWidth()) {
			Text(text = "Play again")
		}
		Spacer(modifier = Modifier.weight(1f))
		Button(onClick = { navigateToRanking(navController) }, Modifier.fillMaxWidth()) {
			Text(text = "See rankings")
		}
		Spacer(modifier = Modifier.weight(1f))
	}
}
package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.montilivi.composenavigation.viewmodel.GameViewModel
import com.montilivi.navigationcompose2.R
import com.montilivi.navigationcompose2.navigation.navigateToChooseUser
import com.montilivi.navigationcompose2.navigation.navigateToGame

@Composable
fun TitleScreen(navController: NavController, vm: GameViewModel) {
	Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
		if (vm.selectedUser != null)
		{
			DisplayUser(vm = vm, user = vm.selectedUser!!, { navigateToChooseUser(navController) })
		}
		Spacer(modifier = Modifier.weight(1f))
		Image(painter = painterResource(id = R.drawable.game_logo), contentDescription = null, Modifier.fillMaxWidth())
		Spacer(modifier = Modifier.weight(1f))
	}

}
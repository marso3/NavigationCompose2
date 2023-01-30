package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.montilivi.composenavigation.model.User
import com.montilivi.composenavigation.viewmodel.GameViewModel

@Composable
fun DisplayUser(vm: GameViewModel, user: User, clickFunction: () -> Unit = {}) {
	Row(Modifier
		.background(Color(0xffcc7a00))
		.selectable(
			selected = user.id == vm.selectedIndex,
			onClick = clickFunction)
	) {
		Image(painter = painterResource(user.icon), null)
		Text(text = user.name,
			Modifier
				.fillMaxWidth()
				.weight(2f)
				.align(Alignment.CenterVertically))
	}
}

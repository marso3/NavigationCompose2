package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.montilivi.composenavigation.model.RegisteredUsers
import com.montilivi.composenavigation.viewmodel.GameViewModel
import com.montilivi.navigationcompose2.navigation.navigateToRegister

@Composable
fun ChooseUserScreen(navController: NavController, vm: GameViewModel) {
	val listState = rememberLazyListState()


	Column(Modifier.fillMaxWidth()) {
		Button(onClick = { navigateToRegister(navController) }) {
			Text(text = "Sign Up")
		}
		LazyColumn(Modifier.weight(1f), state = listState) {
			items(RegisteredUsers.Items) { user ->
				DisplayUser(vm = vm, user = user,
					clickFunction = {
						if (vm.selectedIndex != user.id) { vm.selectedIndex = user.id; vm.selectedUser = user }
						else { vm.selectedIndex = -1; vm.selectedUser = null }
						navController.popBackStack()
					})
			}
		}
	}

}
package com.montilivi.composenavigation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.montilivi.composenavigation.model.RegisteredUsers
import com.montilivi.composenavigation.model.User
import com.montilivi.composenavigation.viewmodel.GameViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RankingScreen(navController: NavController, vm: GameViewModel) {
	var userList = RegisteredUsers.Items.sortedBy { it.maxScore }.toMutableList()
	for (i in 1 .. RegisteredUsers.Items.size) {
		userList[i - 1].position = i
	}

	LazyColumn {
		stickyHeader {
			DisplayRankingHeader()
		}
		items(userList.sortedBy { it.position }) { user ->
			DisplayRankingUser(vm = vm, user = user)
		}
	}
}

@Composable
fun DisplayRankingHeader() {
	Row(Modifier
		.fillMaxWidth()
		.background(Color(0xffcc7acc))
	) {
		Text(text = "Position", Modifier.weight(1f))
		Spacer(modifier = Modifier.weight(1f))
		Text(text = "Name", Modifier.weight(1f))
		Text(text = "Max score", Modifier.weight(1f))
		Text(text = "Total score", Modifier.weight(1f))
	}
}

@Composable
fun DisplayRankingUser(vm: GameViewModel, user: User, clickFunction: () -> Unit = {}) {
	Row(Modifier
		.fillMaxWidth()
		.background(Color(0xffcc7a00))
		.selectable(selected = user.id == vm.selectedIndex, onClick = clickFunction)
	) {
		Text(text = user.position.toString(), Modifier.weight(1f))
		Image(painter = painterResource(user.icon), null, Modifier.weight(1f))
		Text(text = user.name, Modifier.weight(1f))
		Text(text = user.maxScore.toString(), Modifier.weight(1f))
		Text(text = user.totalScore.toString(), Modifier.weight(1f))
	}
}
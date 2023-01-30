package com.montilivi.composenavigation2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.montilivi.composenavigation.model.RegisteredUsers
import com.montilivi.navigationcompose2.R
import com.montilivi.navigationcompose2.navigation.navigateBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterUserScreen(navController: NavController) {
	Row() {

		Row() {
			LazyColumn(Modifier
				.fillMaxWidth()
				.weight(1f)) {
				items(RegisteredUsers.Items) { user ->
					Image(painter = painterResource(user.icon), null)
				}
			}
			Column(Modifier
				.fillMaxWidth()
				.weight(2f)
				.padding(10.dp)) {
				Image(painter = painterResource(id = R.drawable.woman_icon_1), contentDescription = null,
					  Modifier.align(CenterHorizontally))
				OutlinedTextField(value = "username", onValueChange = {})
				Spacer(modifier = Modifier.weight(1f))
				Button(onClick = { navigateBack(navController) }, Modifier.fillMaxWidth()) {
					Text(text = "Accept")
				}
			}
		}

	}
}

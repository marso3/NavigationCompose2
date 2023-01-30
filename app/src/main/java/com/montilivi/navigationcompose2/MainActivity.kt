package com.montilivi.navigationcompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montilivi.composenavigation.screens.RankingScreen
import com.montilivi.composenavigation.viewmodel.GameViewModel
import com.montilivi.composenavigation2.screens.*
import com.montilivi.navigationcompose2.navigation.Destination
import com.montilivi.navigationcompose2.navigation.MainNavigationBar
import com.montilivi.navigationcompose2.navigation.MainNavigationDrawer
import com.montilivi.navigationcompose2.ui.theme.NavigationCompose2Theme

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContent {
			NavigationCompose2Theme { // A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					val navController = rememberNavController()
					MainNavigationBar(GameViewModel(), navController)
					//MainNavigationDrawer(vm = GameViewModel(), navController = navController)
				}
			}
		}
	}
}

@Composable
fun Main(vm : GameViewModel, navController: NavHostController, innerPadding: PaddingValues = PaddingValues(0.dp)) {

	NavHost(navController = navController,
		startDestination = Destination.Title.route,
		modifier = Modifier.padding(innerPadding)) {
		composable(Destination.Title.route) {
			TitleScreen(navController, vm)
		}
		composable(Destination.ChooseUser.route) {
			ChooseUserScreen(navController, vm)
		}
		composable(Destination.RegisterUser.route) {
			RegisterUserScreen(navController)
		}
		composable(Destination.Game.route) {
			GameScreen(navController)
		}
		composable(Destination.GameWon.route) {
			GameWonScreen(navController)
		}
		composable(Destination.GameLost.route) {
			GameLostScreen(navController)
		}
		composable(Destination.Ranking.route) {
			RankingScreen(navController, vm)
		}
	}
}
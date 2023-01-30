package com.montilivi.navigationcompose2.navigation

import androidx.navigation.NavController

sealed class Destination (val route: String)
{
	object Title: Destination("Title")
	object ChooseUser: Destination("ChooseUser")
	object RegisterUser: Destination("RegisterUser")
	object Game: Destination("Game")
	object GameWon: Destination("GameWon")
	object GameLost: Destination("GameLost")
	object Ranking: Destination("Ranking")
}

fun navigateToChooseUser(navController : NavController) {
	navController.navigate(Destination.ChooseUser.route) {
		popUpTo(Destination.ChooseUser.route)
	}
}

fun navigateToGame(navController : NavController) {
	navController.navigate(Destination.Game.route) {
		popUpTo(Destination.Game.route)
	}
}

fun navigateToRegister(navController: NavController) {
	navController.navigate(Destination.RegisterUser.route) {
		popUpTo(Destination.RegisterUser.route)
	}
}

fun navigateToGameWon(navController: NavController) {
	navController.navigate(Destination.GameWon.route) {
		popUpTo(Destination.GameWon.route)
	}
}

fun navigateToGameLost(navController: NavController) {
	navController.navigate(Destination.GameLost.route) {
		popUpTo(Destination.GameLost.route)
	}
}

fun navigateBack(navController: NavController) {
	navController.popBackStack()
}

fun navigateToRanking(navController: NavController) {
	navController.navigate(Destination.Ranking.route) {
		popUpTo(Destination.Ranking.route)
	}
}
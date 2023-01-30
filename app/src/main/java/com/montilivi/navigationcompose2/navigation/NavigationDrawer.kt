package com.montilivi.navigationcompose2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.montilivi.composenavigation.viewmodel.GameViewModel
import com.montilivi.navigationcompose2.Main
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigationDrawer(vm: GameViewModel, navController: NavHostController)
{
	var currentRoute by remember { mutableStateOf(Destination.Title.route) }
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()

	navController.addOnDestinationChangedListener(
		NavController.OnDestinationChangedListener {
			controller, destination, arguments ->
			currentRoute = controller.currentDestination?.route?:Destination.Title.route
		}
	)

	ModalNavigationDrawer(
		drawerState = drawerState,
		gesturesEnabled = currentRoute == Destination.Title.route,
		drawerContent = {
			ModalDrawerSheet() {
				for (element in NavigationDrawerItems.Items) {
					NavigationDrawerItem(
						icon = {
							if (currentRoute == element.route)
								Icon(element.image, null)
							else
								Icon(element.selectedImage, null)
						},
						label = { Text(text = element.title) },
						selected = true,
						onClick = {
							scope.launch {
								if(drawerState.isClosed) drawerState.open() else drawerState.close()
							}
							navController.navigate(element.route)
						}
					)
				}
			}
		},
		content = {
			Scaffold(
				topBar = { TitleBarDrawer(navController, currentRoute, scope, drawerState) },
				content = { Main(vm = vm, navController = navController, it) }
			)
		})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBarDrawer(navController: NavHostController,
				   currentRoute: String = "",
				   scope: CoroutineScope,
				   drawerState: DrawerState)
{
	TopAppBar(title = { Text(text = "Decissor") },
		navigationIcon = { IconButton(
			onClick = {
				if (currentRoute != "" && currentRoute == Destination.Title.route)
				{
					scope.launch {
						if (drawerState.isClosed) drawerState.open() else drawerState.close()
					}
				}
				else
					navController.navigateUp()
			}) {
			if (currentRoute != "" && currentRoute == Destination.Title.route)
				Icon(Icons.Filled.Menu, null)
			else
				Icon(Icons.Filled.ArrowBack, null)
		} },
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primary,
			navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
			titleContentColor = MaterialTheme.colorScheme.onPrimary
		)
	)
}
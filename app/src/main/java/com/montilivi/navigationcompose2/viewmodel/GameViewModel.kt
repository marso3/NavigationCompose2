package com.montilivi.composenavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.montilivi.composenavigation.model.User

class GameViewModel : ViewModel()
{
	private val _selectedUser : User? = null
	var selectedUser : User? = _selectedUser
	var selectedIndex by mutableStateOf(-1)
}

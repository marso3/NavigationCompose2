package com.montilivi.composenavigation.model

data class User (
	val id: Int,
	val name : String,
	val maxScore : Int,
	val totalScore : Int,
	val icon: Int,
	var position: Int = -1
)
package com.mirz.gameapp.domain.entities

data class GameEntity(
    val id: Int,
    val name: String,
    val image: String,
    val releaseDate: String,
    val description: String,
    val rating: Int
)

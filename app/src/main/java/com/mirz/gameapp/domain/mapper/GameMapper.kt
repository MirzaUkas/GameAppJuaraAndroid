package com.mirz.gameapp.domain.mapper

import com.mirz.gameapp.data.response.GameDetailResponse
import com.mirz.gameapp.data.response.GameResponse
import com.mirz.gameapp.domain.entities.GameEntity

fun GameResponse.map() =
    this.results.map {
        GameEntity(
            id = it.id ?: 0,
            name = it.name ?: "",
            image = it.backgroundImage ?: "",
            rating = it.ratingTop ?: 0,
            releaseDate = it.released ?: "",
            description = "",
        )
    }

fun GameDetailResponse.map() =
    let {
        GameEntity(
            id = it.id ?: 0,
            name = it.name ?: "",
            image = it.backgroundImage ?: "",
            rating = it.ratingTop ?: 0,
            releaseDate = it.released ?: "",
            description = it.description ?: "",
        )
    }
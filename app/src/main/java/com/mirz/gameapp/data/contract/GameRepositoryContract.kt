package com.mirz.gameapp.data.contract

import com.mirz.gameapp.data.response.GameDetailResponse
import com.mirz.gameapp.data.response.GameResponse
import io.reactivex.Single

interface GameRepositoryContract {
    fun getGames(): Single<GameResponse>
    fun getGameDetail(id: Int): Single<GameDetailResponse>
}
package com.mirz.gameapp.data.repository

import com.mirz.gameapp.data.contract.GameRepositoryContract
import com.mirz.gameapp.data.network.ApiService
import javax.inject.Inject

class GameRepository @Inject constructor(private val apiService: ApiService) :
    GameRepositoryContract {

    override fun getGames() = apiService.getGames()
    override fun getGameDetail(id: Int) = apiService.getDetailGame(id)
}
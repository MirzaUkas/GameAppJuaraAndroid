package com.mirz.gameapp.data.network

import com.mirz.gameapp.data.response.GameDetailResponse
import com.mirz.gameapp.data.response.GameResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("games")
    fun getGames(): Single<GameResponse>

    @GET("games/{id}")
    fun getDetailGame(@Path("id") id: Int): Single<GameDetailResponse>
}
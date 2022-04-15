package com.mirz.gameapp.di

import com.mirz.gameapp.data.contract.GameRepositoryContract
import com.mirz.gameapp.data.network.ApiService
import com.mirz.gameapp.data.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository(apiService: ApiService): GameRepositoryContract {
        return GameRepository(apiService)
    }
}
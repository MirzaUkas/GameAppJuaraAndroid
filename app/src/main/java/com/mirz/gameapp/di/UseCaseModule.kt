package com.mirz.gameapp.di

import com.mirz.gameapp.data.contract.GameRepositoryContract
import com.mirz.gameapp.domain.usecases.GetGameDetailUseCase
import com.mirz.gameapp.domain.usecases.GetGamesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetGamesUseCase(repository: GameRepositoryContract) : GetGamesUseCase =
        GetGamesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetDetailGameUseCase(repository: GameRepositoryContract) : GetGameDetailUseCase =
        GetGameDetailUseCase(repository)
}
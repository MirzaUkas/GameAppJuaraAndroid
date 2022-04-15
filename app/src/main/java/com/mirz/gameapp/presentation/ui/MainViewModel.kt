package com.mirz.gameapp.presentation.ui

import androidx.lifecycle.MutableLiveData
import com.mirz.gameapp.domain.entities.GameEntity
import com.mirz.gameapp.domain.usecases.GetGamesUseCase
import com.mirz.gameapp.utils.BaseViewModel
import com.mirz.gameapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val getGamesUseCase: GetGamesUseCase) : BaseViewModel() {
    val resultGames = MutableLiveData<Resource<List<GameEntity>>>()

    fun getGames(){
        val disposable = getGamesUseCase()
            .doOnSubscribe {
                resultGames.value = Resource.loading(null)
            }
            .subscribe { result ->
                resultGames.value = result
            }
        addDisposable(disposable)
    }
}
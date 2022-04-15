package com.mirz.gameapp.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.mirz.gameapp.domain.entities.GameEntity
import com.mirz.gameapp.domain.usecases.GetGameDetailUseCase
import com.mirz.gameapp.utils.BaseViewModel
import com.mirz.gameapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val getGameDetailUseCase: GetGameDetailUseCase) :
    BaseViewModel() {
    val resultGame = MutableLiveData<Resource<GameEntity>>()

    fun getGame(id: Int) {
        val disposable = getGameDetailUseCase(id)
            .doOnSubscribe {
                resultGame.value = Resource.loading(null)
            }
            .subscribe { result ->
                resultGame.value = result
            }
        addDisposable(disposable)
    }
}
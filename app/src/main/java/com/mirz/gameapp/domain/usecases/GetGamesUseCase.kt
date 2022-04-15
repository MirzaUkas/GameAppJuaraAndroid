package com.mirz.gameapp.domain.usecases

import com.mirz.gameapp.data.contract.GameRepositoryContract
import com.mirz.gameapp.domain.entities.GameEntity
import com.mirz.gameapp.domain.mapper.map
import com.mirz.gameapp.utils.Resource
import com.mirz.gameapp.utils.singleIo
import io.reactivex.Single
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repositoryContract: GameRepositoryContract) {
    operator fun invoke(): Single<Resource<List<GameEntity>>> {
        return repositoryContract.getGames().map {
            return@map Resource.success(it.map())
        }.onErrorReturn {
            return@onErrorReturn Resource.error(it.message.toString(), null)
        }.compose(singleIo())
    }
}
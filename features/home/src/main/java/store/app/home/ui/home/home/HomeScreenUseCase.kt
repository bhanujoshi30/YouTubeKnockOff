package store.app.home.ui.home.home

import kotlinx.coroutines.flow.Flow
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoResponse
import store.app.home.ui.home.repo.HomeVideosRepository
import javax.inject.Inject


class HomeScreenUseCase @Inject constructor(private val repo : HomeVideosRepository) {
    fun getList() = repo.getHomeVideoList()
}
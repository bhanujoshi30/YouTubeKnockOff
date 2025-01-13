package store.app.profile

import kotlinx.coroutines.flow.Flow
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoResponse
import store.app.profile.repo.ProfileVideosRepository

import javax.inject.Inject


class ProfileScreenUseCase @Inject constructor(private val repo : ProfileVideosRepository) {
    fun getList() = repo.getHomeVideoList()
}
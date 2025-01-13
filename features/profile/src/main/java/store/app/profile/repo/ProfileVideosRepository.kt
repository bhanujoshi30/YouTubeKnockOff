package store.app.profile.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoResponse
import store.app.core.models.getVideoList
import store.app.core.models.getVideoResponse
import javax.inject.Inject

class ProfileVideosRepository @Inject constructor() {
    fun getHomeVideoList() = flow{
        emit(ResponseWrapper.Loading())
        delay(2000)
        val response= getVideoResponse()
        if (response.VideoDetailModel.isEmpty())
            emit(ResponseWrapper.Failed())
        else emit(ResponseWrapper.Success(response))
    }
}
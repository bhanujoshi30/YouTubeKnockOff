package store.app.trending.usecase

import kotlinx.coroutines.flow.flow
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.models.VideoResponse
import store.app.core.models.getVideoList
import store.app.core.models.getVideoResponse
import javax.inject.Inject

class TrendingRepository @Inject constructor() {
    fun getTrendingList()= flow {
        emit(ResponseWrapper.Loading())
        val response = getVideoResponse()
        if (response.VideoDetailModel.isEmpty())
            emit(ResponseWrapper.Failed())
        else
            emit(ResponseWrapper.Success(response))
    }
}
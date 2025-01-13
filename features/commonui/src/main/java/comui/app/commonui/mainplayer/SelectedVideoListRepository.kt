package comui.app.commonui.mainplayer

import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.models.VideoResponse
import store.app.core.models.arrOfList
import javax.inject.Inject

class SelectedVideoListRepository @Inject constructor() {
        fun getCurrentVideoList(videoId:VideoDetailModel) = flow<ResponseWrapper<VideoResponse>>{
            emit(ResponseWrapper.Loading())
            delay(2000)
            val response= Gson().fromJson(arrOfList, VideoResponse::class.java)
            if (response.VideoDetailModel.isNullOrEmpty())
                emit(ResponseWrapper.Failed())
            else {
                (response.VideoDetailModel as ArrayList).removeIf { it.Id==videoId.Id }
                (response.VideoDetailModel as ArrayList).add(0,videoId)
                response.VideoDetailModel.firstOrNull()?.isHeader=true
                emit(ResponseWrapper.Success(response))
            }
        }
}

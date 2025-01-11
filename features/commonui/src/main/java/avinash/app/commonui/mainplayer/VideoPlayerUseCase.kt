package avinash.app.commonui.mainplayer

import store.app.core.models.VideoDetailModel
import javax.inject.Inject

class VideoPlayerUseCase @Inject constructor(private val repo : SelectedVideoListRepository)  {

    fun getCurrentVideoList(videoId:VideoDetailModel) = repo.getCurrentVideoList(videoId)
}
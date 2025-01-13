package comui.app.commonui.mainplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.player.ExoPlayerUtils
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val useCase: VideoPlayerUseCase,
    val exoPlayerUtils: ExoPlayerUtils
) : ViewModel() {
    private var currentModel = MutableStateFlow<VideoDetailModel?>(null)

    val videoList = currentModel.filterNotNull().flatMapLatest { model ->
        useCase.getCurrentVideoList(model)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), ResponseWrapper.Loading())

    fun updateVideoDetailModel(newModel: VideoDetailModel) {
        currentModel.value = newModel
    }
}
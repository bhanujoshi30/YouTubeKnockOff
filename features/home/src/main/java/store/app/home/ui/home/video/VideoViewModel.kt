package store.app.home.ui.home.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import store.app.core.utils.BaseResponse
import store.app.home.ui.home.usecase.UseCaseVideoFetch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(useCaseHomeVideos:UseCaseVideoFetch) : ViewModel() {

    val shoesList=useCaseHomeVideos.getHomeVideos()
        .stateIn(viewModelScope,
            SharingStarted.WhileSubscribed(),
            BaseResponse.Loading())
}
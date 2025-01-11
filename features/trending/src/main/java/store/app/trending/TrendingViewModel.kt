package store.app.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import store.app.core.models.ResponseWrapper
import store.app.core.player.ExoPlayerUtils
import store.app.trending.usecase.TrendingUseCase
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(private val useCase: TrendingUseCase, val exoPlayerUtils:ExoPlayerUtils) : ViewModel() {

    val trendingList=useCase.getTrendingList().stateIn(viewModelScope, SharingStarted.WhileSubscribed(),ResponseWrapper.Loading())
}
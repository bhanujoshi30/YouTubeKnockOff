package store.app.home.ui.home.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import store.app.core.models.ResponseWrapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeScreenUseCase) : ViewModel() {
    val videoList = repo.getList()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), ResponseWrapper.Loading())
}

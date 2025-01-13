package store.app.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import store.app.core.models.ResponseWrapper
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: ProfileScreenUseCase) : ViewModel() {
    val videoList = repo.getList()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), ResponseWrapper.Loading())
}
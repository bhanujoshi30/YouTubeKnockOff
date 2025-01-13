package comui.app.commonui.mainplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.player.GenerateVideoPlayerDetail
import store.app.core.player.ItemVideoPlayer
import store.app.core.player.SmallVideoPlayer
import store.app.core.theme.MyAppTheme
import store.app.core.utils.shimmerviews.addShimmerEffect
import store.app.core.utils.shimmerviews.videoPLayerWithListShimmerView

@Composable
fun VideoPlayerBottomSheetContent(
    cModel: VideoDetailModel?,
    sheetState: ModalBottomSheetState? = null
) {
    MyAppTheme(isSystemInDarkTheme()) {
        if (cModel == null) {
            return@MyAppTheme
        }
        val context = LocalContext.current
        val viewModel: VideoPlayerViewModel = hiltViewModel()
        val data by viewModel.videoList.collectAsState()
        val lazyListState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        val selectedVideoModel = remember { mutableStateOf<VideoDetailModel?>(null) }

        LaunchedEffect(sheetState?.currentValue,selectedVideoModel.value) {
            if (sheetState?.currentValue == ModalBottomSheetValue.Hidden)
                viewModel.exoPlayerUtils.stop()
        }

        LaunchedEffect(cModel) {
            viewModel.updateVideoDetailModel(cModel!!)
        }


        when (val response = data) {
            is ResponseWrapper.Success -> {
                Column {
                    selectedVideoModel.value = response.data.VideoDetailModel.first()
                    SmallVideoPlayer(context, selectedVideoModel.value, viewModel.exoPlayerUtils)
                    LazyColumn(
                        state = lazyListState,
                        modifier = Modifier.background(MaterialTheme.colors.background)
                    ) {
                        items(response.data.VideoDetailModel) {
                            if (it.isHeader)
                                GenerateVideoPlayerDetail(context, it)
                            else
                                ItemVideoPlayer(it, context) { selectModel ->
                                    //viewModel.currentModel.value?.isHeader=false
                                    scope.launch {  lazyListState.scrollToItem(0)}
                                    selectedVideoModel.value = null
                                    viewModel.updateVideoDetailModel(selectModel)
                                }
                        }
                    }
                }

            }

            is ResponseWrapper.Failed -> {}
            is ResponseWrapper.Loading -> {
                addShimmerEffect {
                    videoPLayerWithListShimmerView()
                }
            }
        }

    }
}
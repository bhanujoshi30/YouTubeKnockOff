package store.app.home.ui.home.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import store.app.core.base.BaseBottomSheetFragment
import store.app.core.models.getVideoList
import store.app.core.player.GenerateVideoPlayerDetail
import store.app.core.player.itemVideoPlayer
import store.app.core.theme.MyAppTheme
import store.app.core.utils.shimmerviews.addShimmerEffect
import store.app.core.utils.setBottomSheetScrollBehaviour
import store.app.core.utils.shimmerviews.videoPLayerWithListShimmerView
import store.app.home.databinding.VideoBottomSheetBinding


class VideoBottomSheetFragment : BaseBottomSheetFragment() {
    private lateinit var binding: VideoBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = VideoBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initView()
    }

    private fun VideoBottomSheetBinding.initView() {
        rvSuggestionsVideos.setContent {
            MyAppTheme(isSystemInDarkTheme()) {

                val context = LocalContext.current
                var videoList = getVideoList()// listOf<VideoDetailModel>()

                val lazyListState  = setBottomSheetScrollBehaviour(dialog)

                var isLoading by remember { mutableStateOf(false) }

                var currentModel by remember { mutableStateOf(videoList[0]) }
                //val bottomSheet= LocalBottomSheetManager.current


                LaunchedEffect(currentModel) {
                   // lazyListState.scrollToItem(index = 0)
                    delay(2000)
                    videoList = getVideoList()
                    isLoading=false
                }

                Column {
                    //VideoPlayer(context,currentModel)
                    if (isLoading) {
                        addShimmerEffect {
                            videoPLayerWithListShimmerView()
                        }
                    } else {
                        LazyColumn(
                            state = lazyListState,
                            modifier = Modifier.background(MaterialTheme.colors.background)
                        ) {
                            items(videoList) {
                                if (it.isHeader)
                                    GenerateVideoPlayerDetail(context, currentModel)
                                else
                                    itemVideoPlayer(it, context) { selectModel ->
                                        isLoading = true
                                        currentModel.isHeader = false
                                        selectModel.isHeader = true
                                        currentModel = selectModel
                                    }
                            }
                        }
                    }
                }

            }
        }
    }
}

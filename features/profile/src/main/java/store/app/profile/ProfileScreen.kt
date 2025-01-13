package store.app.profile


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.player.ItemVideoPlayer
import store.app.core.utils.shimmerviews.addShimmerEffect
import store.app.core.utils.shimmerviews.videoPLayerListShimmerView


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: ProfileViewModel = hiltViewModel()
    var selectedVideoModel by remember { mutableStateOf<VideoDetailModel?>(null) }
    val data by viewModel.videoList.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(data) {
        val response = data
        if (response is ResponseWrapper.Failed) {
            snackbarHostState.showSnackbar(response.errorMessage)
        }
    }
    val localContext = LocalContext.current
    val testImgUrl =
        "https://wallpapers.com/images/featured/really-cool-cars-pictures-7gub7gjfes26vk0c.jpg"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            GlideImage(
                model = testImgUrl,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentDescription = "Circular Image",
                requestBuilderTransform = {
                    Glide.with(localContext)
                        .load(testImgUrl)
                        .transform(CircleCrop())
                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = "User name")
                Text(text = "UserID")
                Button(
                    onClick = {
                    }, colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(
                        text = "Logout", color = Color.White, textAlign = TextAlign.Center
                    )
                }
            }
        }
        Text(text = "Liked")
        when (val videoResponse = data) {
            is ResponseWrapper.Success -> {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    items(videoResponse.data.VideoDetailModel) {
                        ItemVideoPlayer(it, context, false) { currentModel ->
                            selectedVideoModel = currentModel
                        }
                    }
                }
            }

            is ResponseWrapper.Failed -> {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier
                            .zIndex(1f)
                    )
                }

            }

            is ResponseWrapper.Loading -> {
                addShimmerEffect {
                    videoPLayerListShimmerView()
                }
            }
        }
        Text(text = "History")
        when (val videoResponse = data) {
            is ResponseWrapper.Success -> {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    items(videoResponse.data.VideoDetailModel) {
                        ItemVideoPlayer(it, context, false) { currentModel ->
                            selectedVideoModel = currentModel
                        }
                    }
                }
            }

            is ResponseWrapper.Failed -> {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier
                            .zIndex(1f)
                    )
                }

            }

            is ResponseWrapper.Loading -> {
                addShimmerEffect {
                    videoPLayerListShimmerView()
                }
            }
        }
        Text(text = "Watch Later")
        when (val videoResponse = data) {
            is ResponseWrapper.Success -> {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    items(videoResponse.data.VideoDetailModel) {
                        ItemVideoPlayer(it, context, false) { currentModel ->
                            selectedVideoModel = currentModel
                        }
                    }
                }
            }

            is ResponseWrapper.Failed -> {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier
                            .zIndex(1f)
                    )
                }

            }

            is ResponseWrapper.Loading -> {
                addShimmerEffect {
                    videoPLayerListShimmerView()
                }
            }
        }
    }


}
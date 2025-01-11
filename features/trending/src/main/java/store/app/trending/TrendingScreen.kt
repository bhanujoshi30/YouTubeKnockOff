package store.app.trending


import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import store.app.core.models.ResponseWrapper
import store.app.core.player.ExoPlayerUtils
import store.app.core.player.FullScreenVideoPlayer
import store.app.core.player.VideoPlayer

@Composable
fun TrendingScreen(navController: NavController) {
    val viewModel: TrendingViewModel = hiltViewModel()
    val data by viewModel.trendingList.collectAsState()
    val context = LocalContext.current

    when(val response = data){
        is ResponseWrapper.Success->{
            val list=response.data.VideoDetailModel
            val lazyListState = rememberPagerState(pageCount = {response.data.VideoDetailModel.size})

            VerticalPager(lazyListState,pageSize = PageSize.Fill) {pageIndex->
                val exoPlayerUtils=ExoPlayerUtils(context)
                DisposableEffect(exoPlayerUtils) {
                    onDispose {
                        Log.e("testCode","code........release")
                        exoPlayerUtils.release()
                    }
                }
                Log.e("testCode","code........"+exoPlayerUtils.hashCode() +" at "+pageIndex)
                FullScreenVideoPlayer(context,list.elementAtOrNull(pageIndex), exoPlayerUtils)
            }

        }
        is ResponseWrapper.Loading->{
            CircularProgressIndicator()
        }
        is ResponseWrapper.Failed->{}
    }

}
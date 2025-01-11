package store.app.home.ui.home.player

import android.net.Uri
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import store.app.core.player.itemVideoPlayer
import store.app.core.utils.toDp

class SuggestedVideoAdapter(val onclick:()->Unit) : RecyclerView.Adapter<SuggestedVideoAdapter.MyVH>() {

    inner class MyVH(private val composeView: ComposeView) :RecyclerView.ViewHolder(composeView){

        fun onBind(position: Int){
            composeView.setContent {
               // itemVideoPlayer(LocalContext.current,onclick)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val view=ComposeView(parent.context).apply {
            layoutParams=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        return MyVH(view)
    }

    override fun getItemCount() = 8

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.onBind(position)
    }
}
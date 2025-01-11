package store.app.core.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import org.jetbrains.annotations.ApiStatus.Internal
import javax.inject.Inject

class ExoPlayerUtils @Inject constructor(@ApplicationContext private val context: Context){
    private var exoPlayer:ExoPlayer?=null

    fun getExoPlayer():ExoPlayer?{
        if (exoPlayer==null)
            exoPlayer = ExoPlayer.Builder(context).build()
        return exoPlayer
    }

    fun setPlayerUrl(videoUrl: String?){
        exoPlayer?.apply {
            apply {
                val mediaItem = MediaItem.fromUri(videoUrl?:"")
                setMediaItem(mediaItem)
                prepare()
                playWhenReady=true
            }
        }
    }

    fun playVideo(){
        exoPlayer?.play()
    }

    fun release(){
        exoPlayer?.release()
        exoPlayer=null
    }

    fun stop(){
        exoPlayer?.stop()
        exoPlayer?.clearMediaItems()
    }

}
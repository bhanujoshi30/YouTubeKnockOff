package store.app.core.player

import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import store.app.core.R
import store.app.core.models.VideoDetailModel
import store.app.core.theme.MyAppTheme


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    context: Context,
    videoDetailModel: VideoDetailModel?,
    exoPlayerUtils: ExoPlayerUtils,
    modifier: Modifier
) {

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        AndroidView(
            factory = { _ ->
                PlayerView(context).apply {
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    val exo = exoPlayerUtils.getExoPlayer()
                    exoPlayerUtils.setPlayerUrl(videoDetailModel?.videoModel?.videoUrl)
                    player=exo
                    exoPlayerUtils.playVideo()
                }
            },
            modifier = modifier
        )
    }
}

@Composable
fun SmallVideoPlayer(context: Context,
                     videoDetailModel: VideoDetailModel?,
                     exoPlayerUtils: ExoPlayerUtils){
    VideoPlayer(context,videoDetailModel,exoPlayerUtils,Modifier.fillMaxWidth()
        .height(300.dp))
}

@Composable
fun FullScreenVideoPlayer(context: Context,
                     videoDetailModel: VideoDetailModel?,
                     exoPlayerUtils: ExoPlayerUtils){
    Box {
        VideoPlayer(context,videoDetailModel,exoPlayerUtils,Modifier.fillMaxWidth()
            .fillMaxHeight())
        channelDetailforfullScreenVideo(context,videoDetailModel!!,Modifier.align(Alignment.BottomStart).padding(16.dp))
    }

}


@Composable
fun GenerateVideoPlayerDetail(
    context: Context,
    videoDetailModel: VideoDetailModel,
    modifier: Modifier = Modifier
        .padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 16.dp
        )
        .height(200.dp)
) {

    Column(modifier) {
        Text(
            videoDetailModel.videoModel.videoTitle,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1
        )
        channelDetailforSmallvideoScreen(context, videoDetailModel)
        likeDislikeButtonBar(videoDetailModel)
        commentView(videoDetailModel)
    }
}

@Composable
private fun likeDislikeButtonBar(
    videoDetailModel: VideoDetailModel,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp)
) {
    Row(modifier) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_like_24),
                    contentDescription = "like",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.size(20.dp),
                )

                Spacer(Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(color = MaterialTheme.colors.onBackground)
                )
                Spacer(Modifier.width(12.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_like_24),
                    contentDescription = "dislike",
                    modifier = Modifier
                        .graphicsLayer(rotationZ = 180f)
                        .size(20.dp),
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}


@Composable
private fun commentView(
    videoDetailModel: VideoDetailModel, modifier: Modifier = Modifier
        .padding(top = 16.dp, bottom = 4.dp)
        .fillMaxWidth()
        .wrapContentHeight()
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(16.dp))
    ) {
        LazyColumn(Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)) {
            val list = if (videoDetailModel.videoModel.commentsList.isNullOrEmpty()) listOf(
                1,
                2
            ) else videoDetailModel.videoModel.commentsList
            items(list) {
                Text(
                    text = "this is Comment $it",
                    Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onBackground
                )
                Spacer(Modifier.height(4.dp))
            }
        }
    }
}

@kotlin.OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun channelDetailforSmallvideoScreen(
    context: Context,
    videoDetailModel: VideoDetailModel,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        GlideImage(
            model = videoDetailModel.channelModel.channelLogo,
            modifier = Modifier
                .width(25.dp)
                .height(25.dp),
            contentDescription = "Circular Image",
            requestBuilderTransform = {
                Glide.with(context)
                    .load(videoDetailModel.channelModel.channelLogo)
                    .transform(CircleCrop())
            }
        )

        Text(
            text = videoDetailModel.channelModel.channelTitle,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )

        Box(
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_notifications_24),
                "notificaiton",
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}

@kotlin.OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun channelDetailforfullScreenVideo(
    context: Context,
    videoDetailModel: VideoDetailModel,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
) {
    Column(modifier = modifier) {
        Column(modifier=Modifier.align(Alignment.End)) {
            AddIconText(R.drawable.ic_like_24,"24k")
            AddIconText(R.drawable.ic_dislike_24,"Dislike")
            AddIconText(R.drawable.ic_share_24,"Share")
        }
        Row( verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 24.dp)) {

            GlideImage(
                model = videoDetailModel.channelModel.channelLogo,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentScale = ContentScale.FillHeight,
                contentDescription = "Circular Image",
                requestBuilderTransform = {
                    Glide.with(context)
                        .load(videoDetailModel.channelModel.channelLogo)
                        .transform(CircleCrop())
                }
            )

            Text(
                text = videoDetailModel.channelModel.channelTitle,
                color = Color.White,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )

            Image(painterResource(R.drawable.ic_more_24),"", modifier=Modifier.size(24.dp), colorFilter = ColorFilter.tint(Color.White))
        }
        Text(
            videoDetailModel.videoModel.videoTitle,
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier=Modifier.padding(top = 12.dp, start = 20.dp, bottom = 16.dp)
        )
    }
}

@Composable
private fun AddIconText(resId: Int, text: String) {
    val colorFilter = ColorFilter.tint(Color.White)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.padding(bottom = 16.dp) ) {
        Image(painterResource(resId),"", modifier=Modifier.padding(bottom = 6.dp).size(32.dp), colorFilter = colorFilter)
        Text(text,color=Color.White, style = MaterialTheme.typography.h3)
    }
}


@Preview(showSystemUi = true)
@Composable
fun testUI() {
    MyAppTheme(true) {
        Column(modifier = Modifier) {

            Image(
                painter = painterResource(R.drawable.a),
                contentDescription = "",
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            ConstraintLayout(
                Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    )
                    .fillMaxWidth()
            ) {
                val (logo, content, more) = createRefs()
                val url =
                    "https://wallpapers.com/images/featured/really-cool-cars-pictures-7gub7gjfes26vk0c.jpg"
                Image(
                    painter = painterResource(R.drawable.a),
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                        .constrainAs(logo) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        },
                    contentDescription = "Circular Image",
                )

                Column(modifier = Modifier
                    .padding(start = 12.dp)
                    .constrainAs(content) {
                        start.linkTo(logo.end)
                        top.linkTo(parent.top)
                        end.linkTo(more.start)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }) {
                    Text(
                        text = "This is the title of the video",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier
                            .wrapContentSize()
                    )

                    Text(
                        text = "Description of the video",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 4.dp)
                    )
                }

                Icon(
                    painter = painterResource(R.drawable.ic_more_24),
                    "more",
                    modifier = Modifier.constrainAs(more) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
            }
        }
    }
}
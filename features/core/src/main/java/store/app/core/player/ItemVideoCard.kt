package store.app.core.player

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import store.app.core.R
import store.app.core.models.VideoDetailModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemVideoPlayer(
    videoDetailModel: VideoDetailModel,
    context: Context,
    insertInRow: Boolean = false,
    onClickBody: (model: VideoDetailModel) -> Unit
) {
    val (modifier, height) = if (insertInRow)
        Pair(Modifier.width(250.dp), 150.dp)
    else
        Pair(Modifier, 250.dp)

    Column(modifier = modifier
        .padding(end = 16.dp)
        .clickable { onClickBody.invoke(videoDetailModel) }) {
        GlideImage(
            model = videoDetailModel.imgUrl,
            contentDescription = "",
            modifier = Modifier
                .height(height)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )

        ConstraintLayout(
            Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 16.dp, end = 8.dp)
                .fillMaxWidth()
        ) {
            val (logo, content, more) = createRefs()

            GlideImage(
                model = videoDetailModel.channelModel.channelLogo,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .constrainAs(logo) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentDescription = "Circular Image",
                requestBuilderTransform = {
                    Glide.with(context)
                        .load(videoDetailModel.channelModel.channelLogo)
                        .transform(CircleCrop())
                }
            )

            Column(modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxWidth()
                .constrainAs(content) {
                    start.linkTo(logo.end)
                    top.linkTo(parent.top)
                    end.linkTo(more.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }) {
                Text(
                    text = videoDetailModel.title,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.wrapContentSize(),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Text(
                    text = videoDetailModel.description,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Icon(
                painter = painterResource(R.drawable.ic_more_24),
                "more",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier.constrainAs(more) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
        }
    }
}




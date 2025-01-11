package store.app.core.utils.shimmerviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import store.app.core.R

@Composable
fun videoPLayerWithListShimmerView(){
    Column {
        Box(modifier = Modifier.fillMaxWidth().height(300.dp).background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(4.dp))) {
        }
        LazyColumn(userScrollEnabled = false) {
            items(listOf(1,2,3)){
                if (it==1)
                    videoPlayerWithDetailShimmerView()
                else {
                    itemVideoPlayerShimmerView()
                }
            }
        }
    }
}


@Composable
fun videoPLayerListShimmerView(){
    Column {
        LazyColumn(userScrollEnabled = false) {
            items(listOf(1,2,3)){
                itemVideoPlayerShimmerView()
            }
        }
    }
}

@Composable
fun videoPlayerWithDetailShimmerView() {
    Column(modifier= Modifier
        .padding(16.dp)
        .wrapContentHeight()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(
                MaterialTheme.colors.onSecondary,
                shape = RoundedCornerShape(6.dp)
            ))
        //channel detail
        Row(modifier=Modifier.padding(top = 16.dp),verticalAlignment = Alignment.CenterVertically) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = MaterialTheme.colors.onSecondary, shape = CircleShape) // Circle shape
            )


            Box(
                modifier = Modifier
                    .height(30.dp)
                    .weight(1f)
                    .padding(start = 12.dp, end = 12.dp)
                    .background(
                        color = MaterialTheme.colors.onSecondary,
                        shape = RoundedCornerShape(6.dp)
                    ) // Circle shape
            )
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height(30.dp)
                    .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(4.dp))
            )
        }

        //like dislike
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .padding(top = 8.dp)
                .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(16.dp))
        )
        //comment view
        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(6.dp))
                .fillMaxWidth()
                .height(50.dp))
    }
}


@Composable
private fun itemVideoPlayerShimmerView() {
    Column(Modifier.padding(16.dp)) {
        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(6.dp))
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
                    .background(MaterialTheme.colors.onSecondary, shape = CircleShape)

            )

            Box(modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .weight(1f)
                .height(25.dp)
                .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(6.dp))
            )

            Icon(
                painter = painterResource(R.drawable.ic_more_24),
                "more",
                tint = MaterialTheme.colors.onSecondary,
                modifier = Modifier
            )
        }
    }
}


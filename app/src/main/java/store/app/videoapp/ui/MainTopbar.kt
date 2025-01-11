package store.app.videoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import store.app.videoapp.R

@Preview
@Composable
fun VideoAppTopBar() {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp).padding(16.dp)) {
        val (categoryImage, categoryTitle, search) = createRefs()
        Icon(
            painter = painterResource(R.drawable.ic_home_outline_32),
            contentDescription = "Search",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier.constrainAs(categoryImage) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(text = "Category",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .constrainAs(categoryTitle) {
                start.linkTo(categoryImage.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(search.start)
                width = Dimension.fillToConstraints
            })
        Icon(
            painter = painterResource(R.drawable.ic_search_24),
            contentDescription = "Search",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier.constrainAs(search) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        )
    }
}
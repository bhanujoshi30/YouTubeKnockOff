package store.app.home.ui.home.video

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import store.app.core.R
import store.app.home.ui.home.routes.HomeGraphRoute



@Composable
fun VideoScreen(navController: NavController) {

    //what will be the advantage of passing backStackEntry?
    val entry= remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry(HomeGraphRoute.RouteScreen.routeName)
    }
    val a: VideoViewModel = hiltViewModel(entry)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(
                rememberNestedScrollInteropConnection()
            ),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            val list=mutableListOf<Test>().apply {
                add(Test("Avinash","Upload very soon"))
                add(Test("Avinash","Upload very soon"))
            }
            items(list.size){
                implementItem(navController,test = list.get(it))
            }
        }
    }
}

data class Test(val first:String,val second:String)

@Composable
fun implementItem(navController: NavController, test: Test = Test("Test", "Test2")){


    Column(Modifier.clickable { navController.navigate(HomeGraphRoute.VideoContentScreen.routeName) }) {
        Image(
            painter = painterResource(id = R.drawable.a) ,"",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(200.dp))

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.a) ,"",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop)

            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.padding(start = 8.dp)) {
                Text(text = test.first, fontSize = 16.sp,color= Color.White)

                Text(text = test.second, fontSize = 12.sp,color= Color.White)

            }
        }

    }
}
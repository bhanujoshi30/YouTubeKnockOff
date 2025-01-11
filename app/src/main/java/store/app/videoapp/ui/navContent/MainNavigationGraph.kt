package store.app.videoapp.ui.navContent

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import store.app.home.ui.home.BottomSheetContainer
import store.app.home.ui.home.homeScreenGraph
import store.app.home.ui.home.routes.HomeGraphRoute
import store.app.home.ui.home.video.VideoFragment
import store.app.profile.ui.profileGraph
import store.app.trending.ui.trendingGraph

@Composable
fun MainNav(navController:NavHostController,modifier: Modifier){
      NavHost(navController = navController,
          startDestination = HomeGraphRoute.RouteScreen.routeName,
          modifier = modifier){
          homeScreenGraph(navController)

          trendingGraph(navController)

          profileGraph(navController)
      }
}




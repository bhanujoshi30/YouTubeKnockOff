package store.app.home.ui.home


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import comui.app.commonui.mainplayer.VideoPlayerBottomSheetContent
import store.app.core.models.VideoDetailModel
import store.app.home.ui.home.home.HomeScreen
import store.app.home.ui.home.routes.HomeGraphRoute
import store.app.home.ui.home.video.attachVideoFragment


fun NavGraphBuilder.homeScreenGraph(navController: NavController){

    navigation(HomeGraphRoute.HomeScreen.routeName,HomeGraphRoute.RouteScreen.routeName){
        composable(HomeGraphRoute.HomeScreen.routeName){
            HomeScreen(navController)
        }

        composable("sheet/{data}"){backStackEntry->
            val data=backStackEntry.arguments?.getParcelable<VideoDetailModel>("data")
            VideoPlayerBottomSheetContent(data)
        }



        composable(HomeGraphRoute.VideoContentScreen.routeName){
            attachVideoFragment()
        }


       /* fragment<VideoFragment>(HomeGraphRoute.VideoContentScreen.routeName){
            VideoFragment()
        }*/
    }
}



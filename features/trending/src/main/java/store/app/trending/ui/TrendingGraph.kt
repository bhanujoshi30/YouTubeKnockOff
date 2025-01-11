package store.app.trending.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import store.app.trending.TrendingScreen
import store.app.trending.ui.routes.TrendingGraphRoute

fun NavGraphBuilder.trendingGraph(navController: NavController){
    navigation(TrendingGraphRoute.TrendingScreen.routeName,TrendingGraphRoute.RouteScreen.routeName){
        composable(TrendingGraphRoute.TrendingScreen.routeName){
            TrendingScreen(navController)
        }
    }
}
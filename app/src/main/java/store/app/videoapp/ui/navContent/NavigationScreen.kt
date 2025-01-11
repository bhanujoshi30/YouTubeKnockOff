package store.app.videoapp.ui.navContent

import androidx.annotation.DrawableRes
import store.app.home.ui.home.routes.HomeGraphRoute
import store.app.profile.ui.routes.MoreGraphRoutes
import store.app.trending.ui.routes.TrendingGraphRoute
import store.app.videoapp.R


sealed class NavigationScreen(val route: String, @DrawableRes val iconID: Int) {
    data object Home : NavigationScreen(
        HomeGraphRoute.RouteScreen.routeName,
        R.drawable.ic_home_outline_32)
    data object Trending : NavigationScreen(
        TrendingGraphRoute.RouteScreen.routeName,
        R.drawable.ic_trending_outline_32)
    object More : NavigationScreen(
        MoreGraphRoutes.RouteScreen.routeName,
        R.drawable.ic_profile_outline_32)
}
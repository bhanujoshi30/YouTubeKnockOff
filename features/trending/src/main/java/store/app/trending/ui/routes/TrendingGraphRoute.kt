package store.app.trending.ui.routes

sealed class TrendingGraphRoute(val routeName:String){
    object TrendingScreen:TrendingGraphRoute("TrendingScreen")
    object RouteScreen:TrendingGraphRoute("Trending's")
}
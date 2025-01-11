package store.app.home.ui.home.routes


sealed class HomeGraphRoute(val routeName:String) {
     data object HomeScreen:HomeGraphRoute("HomeScreen")
     object VideoContentScreen:HomeGraphRoute("VideoScreen")

    object AScreen:HomeGraphRoute("AScreen")

    object BScreen:HomeGraphRoute("BScreen")

    object RouteScreen:HomeGraphRoute("Home")
}
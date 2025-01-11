package store.app.profile.ui.routes

sealed class MoreGraphRoutes(val routeName:String) {
    object ProfileScreen:MoreGraphRoutes("ProfileScreen")
    object RouteScreen:   MoreGraphRoutes("More")
}
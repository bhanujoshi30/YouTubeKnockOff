package store.app.profile.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import store.app.profile.ProfileScreen
import store.app.profile.ui.routes.MoreGraphRoutes


fun NavGraphBuilder.profileGraph(navController: NavController){

    navigation(MoreGraphRoutes.ProfileScreen.routeName,MoreGraphRoutes.RouteScreen.routeName){
        composable(MoreGraphRoutes.ProfileScreen.routeName){
            ProfileScreen(navController)
        }
    }
}
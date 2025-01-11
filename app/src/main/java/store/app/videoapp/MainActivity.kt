package store.app.videoapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import store.app.core.theme.MyAppTheme
import store.app.core.utils.changeStatusBarColor
import store.app.home.ui.home.BottomSheetContainer
import store.app.videoapp.ui.VideoAppTopBar
import store.app.videoapp.ui.navContent.MainNav
import store.app.videoapp.ui.navContent.generateBottomNavigation


@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            MyAppTheme(darkTheme = isSystemInDarkTheme()) {
                changeStatusBarColor()
                Scaffold(
                    topBar = { VideoAppTopBar() },
                    bottomBar = { generateBottomNavigation(navController) }
                ) {innerPadding->
                    MainNav(navController,Modifier.padding(innerPadding))
                }
                //BottomSheetContainer {}

            }
        }
    }
}




package store.app.core.utils

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit


@Composable
fun attachComposeFragment(fragment: Fragment, fragmentTag:String) {
    val fragmentManager = (LocalContext.current as FragmentActivity).supportFragmentManager
    AndroidView(
        factory = { context ->
            // Create a FragmentContainerView

            val fragmentContainerView = FragmentContainerView(context).apply {
                id = View.generateViewId() // Generate unique ID for the container
            }

            // Add the Fragment to the FragmentManager dynamically if not already added
            fragmentManager.commit {
                if (fragmentManager.findFragmentByTag(fragmentTag) == null) {
                    add(fragmentContainerView.id, fragment, fragmentTag)
                }
            }

            fragmentContainerView
        },
        update = { }
    )
}
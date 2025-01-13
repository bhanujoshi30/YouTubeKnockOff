package store.app.home.ui.home.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import store.app.core.utils.attachComposeFragment
import store.app.home.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private lateinit var mBinding: FragmentVideoBinding

    companion object {
        const val TAG = "VideoFragment"
        fun newInstance() = VideoFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentVideoBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.composeView.setContent {
            var isSheetVisible by remember { mutableStateOf(false) }

            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = { isSheetVisible = !isSheetVisible },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text("Toggle Bottom Sheet")
                }
            }

            AnimatedVisibility(
                visible = isSheetVisible,
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.LightGray)
                        .padding(16.dp)
                ) {
                    Text("Custom Bottom Sheet Content")
                }
            }
        }
    }

}

@Composable
fun attachVideoFragment() {
    attachComposeFragment(VideoFragment(), VideoFragment.TAG)
    val fragmentManager = (LocalContext.current as FragmentActivity).supportFragmentManager

    // LaunchedEffect(Unit) { VideoBottomSheetFragment().show(fragmentManager, "MyBottomSheet") }
}









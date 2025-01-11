package store.app.home.ui.home.home

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import avinash.app.commonui.mainplayer.VideoPlayerBottomSheetContent
import store.app.core.models.ResponseWrapper
import store.app.core.models.VideoDetailModel
import store.app.core.models.getVideoList
import store.app.core.player.itemVideoPlayer
import store.app.core.utils.attachComposeFragment
import store.app.core.utils.shimmerviews.addShimmerEffect
import store.app.core.utils.shimmerviews.videoPLayerListShimmerView
import store.app.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvList.apply {
            adapter = HomeAdapter {
                //VideoBottomSheetFragment().show(childFragmentManager,"")
            }
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}


@Composable
fun attachHomeFragment(navController: NavController) {
    attachComposeFragment(HomeFragment.newInstance(), HomeFragment.TAG)
}

@Composable
fun HomeScreen(navController: NavController) {
    //FunMain() return
    val context = LocalContext.current
    val sheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, skipHalfExpanded = true)

    var selectedVideoModel by remember { mutableStateOf<VideoDetailModel?>(null) }
    LaunchedEffect(selectedVideoModel) {
        if (selectedVideoModel != null) {
            sheetState.show()
        }
    }

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == ModalBottomSheetValue.Hidden) {
            selectedVideoModel = null
            sheetState.hide()
        }
    }

    val viewModel: HomeViewModel = hiltViewModel()

    val data by viewModel.videoList.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(data) {
        val response = data
        if (response is ResponseWrapper.Failed) {
            snackbarHostState.showSnackbar(response.errorMessage)
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { VideoPlayerBottomSheetContent(selectedVideoModel,sheetState) },
        content = {
            when (val videoResponse = data) {
                is ResponseWrapper.Success -> {
                    LazyColumn {
                        items(videoResponse.data.VideoDetailModel) {
                            itemVideoPlayer(it, context, false) { currentModel ->
                                selectedVideoModel = currentModel
                            }
                        }
                    }
                }

                is ResponseWrapper.Failed -> {
                    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxHeight()) {
                        SnackbarHost(
                            hostState = snackbarHostState,
                            modifier = Modifier
                                .zIndex(1f)
                        )
                    }

                }

                is ResponseWrapper.Loading -> {
                    addShimmerEffect {
                        videoPLayerListShimmerView()
                    }
                }
            }

        }
    )

}




@Composable
fun FunMain(

) {
    var sharedVariable by remember { mutableStateOf("Initial Value") }
    val context=LocalContext.current
    var a = remember { mutableStateOf(getVideoList())  }
    LaunchedEffect(a.value) {
        a.value= getVideoList()
    }

   // if (a.size==13){
        Column {
            Fun1(sharedVariable) { newValue ->
                // Update sharedVariable when changed in Fun1
                sharedVariable = newValue
                a.value= emptyList()
            }
            Fun2(sharedVariable)
        }
  //  }

}

@Composable
fun Fun1(
    variable: String,
    onVariableChange: (String) -> Unit
) {
    Column {
        Text(text = "Fun1: $variable")
        Button(onClick = { onVariableChange("Updated Value") }) {
            Text("Update Variable")
        }
    }
}

@Composable
fun Fun2(variable: String) {
    // Trigger when 'variable' changes
    LaunchedEffect(variable) {
        println("LaunchedEffect triggered in Fun2 with value: $variable")
    }

    Text(text = "Fun2: $variable")
}




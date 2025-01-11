package store.app.core.utils

import android.app.Dialog
import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


@Composable
fun setBottomSheetScrollBehaviour(dialog: Dialog?):LazyListState{
     val lazyListState = rememberLazyListState()

    val bottomSheetBehavior = (dialog as? BottomSheetDialog)?.behavior

    LaunchedEffect(
          remember { derivedStateOf { lazyListState.firstVisibleItemIndex } } ,
        remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }) {
        bottomSheetBehavior?.isDraggable = lazyListState.firstVisibleItemIndex == 0 && lazyListState.firstVisibleItemScrollOffset == 0
    }
    return lazyListState
}
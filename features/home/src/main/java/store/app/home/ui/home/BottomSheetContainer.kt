package store.app.home.ui.home

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun BottomSheetContainer(content:@Composable () -> Unit ) {

    val sheetState=rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true)
    val listState= rememberLazyListState()
    val bottomSheetManager = remember { BottomSheetManager(sheetState,listState) }
    CompositionLocalProvider(LocalBottomSheetManager provides bottomSheetManager) {
        content()

      /*  ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = { addVideoBottomSheetContent(sheetState,null) }
        ) {}*/
    }
}


val LocalBottomSheetManager = compositionLocalOf<BottomSheetManager> { error("No BottomSheetManager found!") }

class BottomSheetManager(val sheetState: ModalBottomSheetState,val listState:LazyListState) {


    suspend fun showBottomSheet() {
        sheetState.show()
    }

    suspend fun scrollToIndex(index:Int) {
        listState.scrollToItem(index)
    }

    suspend fun hideBottomSheet() {
        sheetState.hide()
    }
}


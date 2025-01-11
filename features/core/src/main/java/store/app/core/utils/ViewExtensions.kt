package store.app.core.utils

import android.app.Activity
import android.content.Context
import android.os.SystemClock
import android.util.TypedValue
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView


fun View.setOnClickListenerDebounce(debounceTime: Long = 600L, action: (v: View) -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action(v)
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}


fun convertIntToDp(mSpace: Int, view: View) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, mSpace.toFloat(), view.resources.displayMetrics
).toInt()


fun Int.toDp(context: Context)=
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()


@Composable
fun changeStatusBarColor(){
    val activity = LocalView.current.context as Activity
    val backgroundArgb = MaterialTheme.colors.background.toArgb()
    activity.window.statusBarColor = backgroundArgb
}
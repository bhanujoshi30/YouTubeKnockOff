package store.app.core.utils.shimmerviews

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun addShimmerEffect(content : @Composable () ->Unit ) {
    val shimmerColors = listOf(
        MaterialTheme.colors.background,
        MaterialTheme.colors.background.copy(alpha = 0.7f),
        MaterialTheme.colors.background
    )

    val translateAnim = rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val brush = Brush.verticalGradient(
        colors = shimmerColors,
        startY = translateAnim.value,
        endY =0f
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().background(MaterialTheme.colors.background)
    ) {
       content()
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer { alpha =.7f }
                .background(brush)
        )
    }
}


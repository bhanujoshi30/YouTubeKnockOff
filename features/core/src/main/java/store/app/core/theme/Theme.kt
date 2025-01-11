package store.app.core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


@Composable
fun MyAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    // Define the colors based on the theme
    val colorScheme = if (darkTheme) {
        darkColors(
            primary = DarkPrimary,
            onPrimary = DarkOnPrimary,
            secondary = DarkSecondary,
            onSecondary = DarkOnSecondary,
            background = DarkBackground,
            onBackground = DarkOnBackground
        )
    } else {
        lightColors(
            primary = LightPrimary,
            onPrimary = LightOnPrimary,
            secondary = LightSecondary,
            onSecondary = LightOnSecondary,
            background = LightBackground,
            onBackground = LightOnBackground
        )
    }


    MaterialTheme(colors = colorScheme, typography = videoAppTypography, content = content)
}
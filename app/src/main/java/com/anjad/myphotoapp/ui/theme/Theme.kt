package com.anjad.myphotoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Immutable
data class CustomDimensions(
    val paddingDefault: Dp,
    val paddingMedium: Dp,
    val paddingSmall: Dp,
)

val LocalCustomDimensions = staticCompositionLocalOf {
    CustomDimensions(
        paddingDefault = Dp.Unspecified,
        paddingMedium = Dp.Unspecified,
        paddingSmall = Dp.Unspecified,
    )
}

@Composable
fun MyPhotoAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val customDimensions = CustomDimensions(
        paddingDefault = 16.dp,
        paddingMedium = 12.dp,
        paddingSmall = 8.dp
    )

    CompositionLocalProvider(
        LocalCustomDimensions provides customDimensions
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object MyPhotoAppTheme {
    val dimensions: CustomDimensions
        @Composable
        get() = LocalCustomDimensions.current
}
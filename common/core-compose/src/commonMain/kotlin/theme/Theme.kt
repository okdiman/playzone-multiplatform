package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides palette,
        LocalShapeProvider provides shapes,
        content = content
    )
}

object Theme {
    val colors: PlayzoneColors
        @Composable
        get() = LocalColorProvider.current
    val shapes: PlayzoneShapes
        @Composable
        get() = LocalShapeProvider.current
}
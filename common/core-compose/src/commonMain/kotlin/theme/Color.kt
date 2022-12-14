package theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class PlayzoneColors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val tagColor: Color,
    val tagTextColor: Color
)

data class PlayzoneShapes(
    val default: Shape
)

val palette = PlayzoneColors(
    primaryBackground = Color(0xFF050B18),
    secondaryBackground = Color(0xFF1F2430),
    primaryAction = Color(0xFFF4D144),
    primaryTextColor = Color(0xFF050B18),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFFF4D144),
    secondaryTextColor = Color(0xFFFFFFFF),
    thirdTextColor = Color(0xFFEEF2FB),
    tagColor = Color(0x1844A9F4),
    tagTextColor = Color(0xFF44A9F4)
)

val shapes = PlayzoneShapes(
    default = RoundedCornerShape(10.dp)
)

val LocalColorProvider =
    staticCompositionLocalOf<PlayzoneColors> { error("No default implementation") }

val LocalShapeProvider =
    staticCompositionLocalOf<PlayzoneShapes> { error("No default implementation") }

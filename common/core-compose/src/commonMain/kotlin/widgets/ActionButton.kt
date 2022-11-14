package widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.Theme

@Composable
inline fun ActionButton(title: String, enabled: Boolean = true, crossinline onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Theme.colors.primaryAction
        ),
        shape = Theme.shapes.default,
        onClick = {
            onClick()
        }) {
        Text(
            text = title,
            color = Theme.colors.primaryTextColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
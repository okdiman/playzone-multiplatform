package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme
import widgets.CommonTextField

@Composable
fun LoginView(viewState: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(top = 36.dp, start = 24.dp, end = 24.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /**
         *  не выношу строки в ресурсы, так как такой подход не будет работать с другими платформами
         *  кроме Андроид
         *  P.S. разобраться с либами для работы с ресурсами, например mockResources
         */
        /**
         *  не выношу строки в ресурсы, так как такой подход не будет работать с другими платформами
         *  кроме Андроид
         *  P.S. разобраться с либами для работы с ресурсами, например mockResources
         */
        Text(
            text = "Login Now",
            color = Theme.colors.secondaryTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
            text = "Welcome back to PlayZone! Enter your email address and your password to enjoy the latest features of PlayZone",
            color = Theme.colors.hintTextColor,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        CommonTextField(
            text = viewState.email,
            hint = "Email Address",
            enabled = !viewState.isSending,
            onValueChanged = { eventHandler(LoginEvent.EmailChanged(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        CommonTextField(
            text = viewState.password,
            hint = "Password",
            isSecure = viewState.passwordHidden,
            enabled = !viewState.isSending,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler(LoginEvent.ShowPasswordClick)
                    },
                    imageVector = if (viewState.passwordHidden) {
                        Icons.Outlined.Lock
                    } else {
                        Icons.Outlined.Clear
                    },
                    contentDescription = "",
                    tint = Theme.colors.hintTextColor
                )
            },
            onValueChanged = { eventHandler(LoginEvent.PasswordChanged(it)) }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text(
                modifier = Modifier
                    .clickable {
                        eventHandler.invoke(LoginEvent.ForgotClick)
                    },
                text = "Forgot password",
                color = Theme.colors.primaryAction,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !viewState.isSending,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            shape = Theme.shapes.default,
            onClick = {
                eventHandler(LoginEvent.LoginClick)
            }) {
            Text(
                text = "Login now",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
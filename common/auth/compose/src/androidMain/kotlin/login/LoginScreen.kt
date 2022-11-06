package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginEvent
import theme.Theme

@Composable
fun LoginScreen() {
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        Column(
            modifier = Modifier.padding(top = 36.dp, start = 24.dp, end = 24.dp, bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            TextField(
                value = state.value.email,
                enabled = !state.value.isSending,
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = Theme.colors.hintTextColor
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Theme.colors.secondaryBackground,
                    textColor = Theme.colors.hintTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Theme.colors.highlightTextColor
                ),
                shape = Theme.shapes.default,
                onValueChange = { newEmail ->
                    viewModel.obtainEvent(LoginEvent.EmailChanged(newEmail))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = state.value.password,
                enabled = !state.value.isSending,
                placeholder = {
                    Text(
                        text = "Password",
                        color = Theme.colors.hintTextColor
                    )
                },
                visualTransformation = if (state.value.passwordHidden) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            viewModel.obtainEvent(LoginEvent.ShowPasswordClick)
                        },
                        imageVector = if (state.value.passwordHidden) {
                            Icons.Outlined.Lock
                        } else {
                            Icons.Outlined.Clear
                        },
                        contentDescription = "",
                        tint = Theme.colors.hintTextColor
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Theme.colors.secondaryBackground,
                    textColor = Theme.colors.hintTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Theme.colors.highlightTextColor
                ),
                shape = Theme.shapes.default,
                onValueChange = { newPassword ->
                    viewModel.obtainEvent(LoginEvent.PasswordChanged(newPassword))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(84.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !state.value.isSending,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Theme.colors.primaryAction
                ),
                shape = Theme.shapes.default,
                onClick = {
                    viewModel.obtainEvent(LoginEvent.LoginClick)
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

}
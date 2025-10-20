package com.example.dataflowassignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dataflowassignment.presentation.ConfirmedInfo
import com.example.dataflowassignment.presentation.FlowUiState
import com.example.dataflowassignment.ui.components.AppHeader
import com.example.dataflowassignment.ui.components.EmailField
import com.example.dataflowassignment.ui.components.PrimaryButton

@Composable
fun ForgotPasswordScreen(
    state: FlowUiState,
    lastConfirm: ConfirmedInfo?,
    onEmailChange: (String) -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        AppHeader(
            title = "Forget Password?",
            subtitle = "Enter your Email, we will send you a verification code.",
            showBack = false
        )

        EmailField(
            value = state.email,
            onValueChange = onEmailChange,
            placeholder = "Your Email"
        )
        Spacer(Modifier.height(16.dp))
        PrimaryButton(text = "Next", onClick = onNext)

        if (lastConfirm != null) {
            Spacer(Modifier.height(12.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondary.copy(0.1f)
                )
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text("Last confirmed", fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(6.dp))
                    Text("Email: ${lastConfirm.email}")
                    Text("OTP: ${lastConfirm.otp}")

                    // Password: có nút ẩn/hiện
                    var show by remember { mutableStateOf(false) }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        val masked = "•".repeat(lastConfirm.password.length.coerceAtLeast(8))
                        Text(
                            text = "Password: " + if (show) lastConfirm.password else masked,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = { show = !show }) {
                            Icon(
                                imageVector = if (show) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = if (show) "Hide" else "Show"
                            )
                        }
                    }
                }
            }
        }

        if (state.loading) {
            Spacer(Modifier.height(16.dp))
            CircularProgressIndicator()
        }

        state.error?.let {
            Spacer(Modifier.height(12.dp))
            Text(text = it, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewForgotPasswordScreen() {
    val dummyState = FlowUiState(email = "")
    MaterialTheme {
        ForgotPasswordScreen(
            state = dummyState,
            lastConfirm = ConfirmedInfo("uth@gmail.com", "12345", "Abcd1234"),
            onEmailChange = {},
            onNext = {}
        )
    }
}

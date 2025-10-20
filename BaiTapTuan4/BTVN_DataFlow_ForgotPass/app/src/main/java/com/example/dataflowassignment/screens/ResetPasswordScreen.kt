package com.example.dataflowassignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dataflowassignment.presentation.FlowUiState
import com.example.dataflowassignment.ui.components.AppHeader
import com.example.dataflowassignment.ui.components.PasswordField
import com.example.dataflowassignment.ui.components.PrimaryButton

@Composable
fun ResetPasswordScreen(
    state: FlowUiState,
    onBack: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(8.dp))
        AppHeader(
            title = "Create new password",
            subtitle = "Your new password must be different form previously used password",
            showBack = true,
            onBack = onBack
        )

        PasswordField(value = state.password, onValueChange = onPasswordChange, placeholder = "Password")
        Spacer(Modifier.height(12.dp))
        PasswordField(value = state.confirmPassword, onValueChange = onConfirmPasswordChange, placeholder = "Confirm Password")
        Spacer(Modifier.height(16.dp))
        PrimaryButton(text = "Next", onClick = onNext)

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
fun PreviewResetPasswordScreen() {
    val dummyState = FlowUiState(password = "Abcd1234", confirmPassword = "")
    MaterialTheme {
        ResetPasswordScreen(
            state = dummyState,
            onBack = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onNext = {}
        )
    }
}

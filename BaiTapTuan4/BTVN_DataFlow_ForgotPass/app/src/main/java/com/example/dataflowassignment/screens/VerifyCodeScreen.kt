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
import com.example.dataflowassignment.ui.components.OtpField
import com.example.dataflowassignment.ui.components.PrimaryButton

@Composable
fun VerifyCodeScreen(
    state: FlowUiState,
    onBack: () -> Unit,
    onOtpChange: (String) -> Unit,
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
            title = "Verify Code",
            subtitle = "Enter the the code we just sent you on your registered Email",
            showBack = true,
            onBack = onBack
        )

        Spacer(Modifier.height(12.dp))
        OtpField(value = state.otp, onValueChange = onOtpChange)
        Spacer(Modifier.height(20.dp))
        PrimaryButton(text = "Next", enabled = state.otp.length == 5, onClick = onNext)

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
fun PreviewVerifyCodeScreen() {
    val dummyState = FlowUiState(otp = "12")
    MaterialTheme {
        VerifyCodeScreen(
            state = dummyState,
            onBack = {},
            onOtpChange = {},
            onNext = {}
        )
    }
}

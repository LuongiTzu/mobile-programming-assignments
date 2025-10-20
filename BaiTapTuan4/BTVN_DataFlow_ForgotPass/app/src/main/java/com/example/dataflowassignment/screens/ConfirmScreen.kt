package com.example.dataflowassignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dataflowassignment.presentation.FlowUiState
import com.example.dataflowassignment.ui.components.AppHeader
import com.example.dataflowassignment.ui.components.PrimaryButton
import com.example.dataflowassignment.ui.theme.DataFlowAssignmentTheme

@Composable
fun ConfirmScreen(
    state: FlowUiState,
    onBack: () -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(8.dp))
        AppHeader(
            title = "Confirm",
            subtitle = "We are here to help you!",
            showBack = true,
            onBack = onBack
        )

        val fieldShape = RoundedCornerShape(10.dp)

        // Email (readonly)
        OutlinedTextField(
            value = state.email,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
            placeholder = { Text("uth@gmail.com") },
            modifier = Modifier.fillMaxWidth(),
            shape = fieldShape
        )

        Spacer(Modifier.height(10.dp))

        // Code (readonly)
        OutlinedTextField(
            value = state.otp,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Key, contentDescription = null) },
            placeholder = { Text("123456") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier.fillMaxWidth(),
            shape = fieldShape
        )

        Spacer(Modifier.height(10.dp))

        // Password (readonly, toggle visibility)
        var showPass by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = state.password,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
            placeholder = { Text("Password") },
            visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { showPass = !showPass }) {
                    Icon(
                        imageVector = if (showPass) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if (showPass) "Hide" else "Show"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = fieldShape
        )

        Spacer(Modifier.height(16.dp))
        PrimaryButton(text = "Submit", onClick = onSubmit)

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

/* ===================== PREVIEW ===================== */

@Preview(showSystemUi = true)
@Composable
private fun PreviewConfirmScreen() {
    DataFlowAssignmentTheme {
        ConfirmScreen(
            state = FlowUiState(
                email = "uth@gmail.com",
                otp = "123456",
                password = "Abcd1234"
            ),
            onBack = {},
            onSubmit = {}
        )
    }
}

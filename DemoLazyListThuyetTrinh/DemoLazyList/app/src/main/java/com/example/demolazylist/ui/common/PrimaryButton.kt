package com.example.demolazylist.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) { Text(text) }
}

@Preview
@Composable
private fun PreviewPrimaryButton() {
    DemoLazyListTheme { PrimaryButton("Tạo", {}) }
}

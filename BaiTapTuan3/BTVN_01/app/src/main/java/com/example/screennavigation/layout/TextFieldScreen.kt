package com.example.screennavigation.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import com.example.screennavigation.ui.theme.ScreenNavigationTheme

@Composable
fun TextFieldScreen(onBack: () -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 30.dp)) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Blue,
                modifier = Modifier.align(Alignment.CenterStart).clickable { onBack() }
            )
            Text(
                text = "TextField",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Blue
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().offset(y = (250).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Thông tin nhập") },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Tự động cập nhật dữ liệu theo textfield",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldScreenPreview() {
    ScreenNavigationTheme { TextFieldScreen(onBack = {}) }
}

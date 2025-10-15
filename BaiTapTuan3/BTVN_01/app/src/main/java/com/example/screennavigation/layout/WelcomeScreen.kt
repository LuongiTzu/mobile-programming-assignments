package com.example.screennavigation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screennavigation.R
import com.example.screennavigation.ui.theme.ScreenNavigationTheme

@Composable
fun WelcomeScreen(onReady: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(70.dp, Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logojet),
            contentDescription = "Jetpack Compose",
            modifier = Modifier.size(170.dp)
        )
        //tạo khoảng cách ta có câu
         Spacer(modifier = Modifier.height(16.dp))
        Text("Jetpack Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp).offset(y = (-50).dp)
        )

        Button(
            onClick = onReady,
            modifier = Modifier.size(width = 200.dp, height = 50.dp).clip(RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6E8CFB)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "I'm ready", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true, name = "WelcomeScreen Preview")
@Composable
fun WelcomeScreenPreview() {
    ScreenNavigationTheme { WelcomeScreen(onReady = {}) }
}

package com.example.dataflowassignment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dataflowassignment.R

@Composable
fun AppHeader(
    title: String,
    subtitle: String?,
    showBack: Boolean,
    onBack: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            if (showBack && onBack != null) {
                BackIcon(onBack = onBack)
            } else {
                Spacer(Modifier.height(36.dp))
            }
        }

        Spacer(Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.logouth),
            contentDescription = "UTH",
            modifier = Modifier
                .size(150.dp)
                .padding(top = 8.dp)
        )
        Text(
            text="SmartTasks",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color (0xFF2196F3)
        )

        Spacer(Modifier.height(40.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
            textAlign = TextAlign.Center
        )

        if (!subtitle.isNullOrBlank()) {
            Spacer(Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(12.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewAppHeader() {
    MaterialTheme {
        AppHeader(
            title = "Verify Code",
            subtitle = "Enter the code we just sent to your email",
            showBack = true
        )
    }
}

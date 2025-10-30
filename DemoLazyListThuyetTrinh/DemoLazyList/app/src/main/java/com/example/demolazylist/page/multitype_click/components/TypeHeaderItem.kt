package com.example.demolazylist.page.multitype_click.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun TypeHeaderItem(title: String, onClick: () -> Unit) {
    Text(
        text = title,
        color = Color.Blue,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(vertical = 2.dp)
            .border(2.dp, Color.Blue, shape = MaterialTheme.shapes.medium)
            .background(Color(0xFFD6E6FF), shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .clickable { onClick() }
    )
}

@Preview
@Composable
private fun PreviewHeader() {
    DemoLazyListTheme { TypeHeaderItem("Header", {}) }
}

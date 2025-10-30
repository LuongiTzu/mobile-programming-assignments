package com.example.demolazylist.page.nestedlazy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun NumberCell(n: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(64.dp).background(Color(0xFFE0E0E0)),
        contentAlignment = Alignment.Center
    ) {
        Text("$n", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview
@Composable
private fun PreviewNumberCell() {
    DemoLazyListTheme { NumberCell(7) }
}

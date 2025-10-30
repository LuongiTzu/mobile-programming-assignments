package com.example.demolazylist.page.multitype_click.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun TypePersonItem(name: String, age: Int, onClick: () -> Unit) {
    Text(
        text = "$name - $age tuổi",
        modifier = Modifier.fillMaxWidth()
            .border(2.dp, Color(0xFFFFC107), shape = MaterialTheme.shapes.medium)
            .background(Color(0xFFFFF8E1), shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 12.dp, vertical = 6.dp).clickable { onClick() }
    )
}

@Preview
@Composable
private fun PreviewPerson() {
    DemoLazyListTheme { TypePersonItem("Conan", 8, {}) }
}

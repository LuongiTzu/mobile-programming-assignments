package com.example.demolazylist.page.addtolayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.common.RoundedItem
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun AddBasicsScreen(onBack: () -> Unit) {
    val data = listOf(
        "Doraemon", "Naruto", "Luffy", "Conan",
        "Songoku", "Gojo", "One Punch Man", "Pikachu", "Senku"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar("Cách thêm 1 Lazy List cơ bản", onBack)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Text("Xin chào!") }
            items(data, key = { it }) { name ->
                RoundedItem(text = name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAddBasics() {
    DemoLazyListTheme { AddBasicsScreen(onBack = {}) }
}

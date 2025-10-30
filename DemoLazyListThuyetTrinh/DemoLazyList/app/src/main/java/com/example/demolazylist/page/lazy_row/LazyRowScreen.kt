package com.example.demolazylist.page.lazy_row

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.common.NumberField
import com.example.demolazylist.ui.common.PrimaryButton
import com.example.demolazylist.ui.common.RoundedItem
import com.example.demolazylist.ui.theme.DemoLazyListTheme
import com.example.demolazylist.util.isPositiveInt

@Composable
fun LazyRowScreen(onBack: () -> Unit) {
    var input by remember { mutableStateOf("5") }
    val list = remember { mutableStateListOf<Int>() }

    // Khởi tạo danh sách ban đầu
    LaunchedEffect(Unit) {
        repeat(input.toIntOrNull() ?: 5) { i ->
            list.add(i + 1)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Thanh tiêu đề
        AppTopBar("Lazy Row", onBack)

        // Ô nhập + nút Tạo (căn giữa dọc)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically // ✅ căn giữa nút theo dọc
        ) {
            NumberField(
                value = input,
                onValueChange = { input = it },
                label = "Nhập số",
                modifier = Modifier.weight(1f)
            )

            PrimaryButton(
                text = "Tạo",
                onClick = {
                    list.clear()
                    if (isPositiveInt(input)) {
                        repeat(input.toInt()) { i ->
                            list.add(i + 1)
                        }
                    }
                }
            )
        }

        // Danh sách hiển thị ngang
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list, key = { it }) { n ->
                RoundedItem(text = n.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLazyRow() {
    DemoLazyListTheme { LazyRowScreen(onBack = {}) }
}

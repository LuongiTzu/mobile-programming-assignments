package com.example.demolazylist.page.lazy_column

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import kotlinx.coroutines.launch

@Composable
fun LazyColumnScreen(onBack: () -> Unit) {
    val snack = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var input by remember { mutableStateOf("4") }
    val list = remember { mutableStateListOf<Int>() }

    // Cập nhật danh sách khởi tạo ban đầu
    LaunchedEffect(Unit) {
        repeat(input.toIntOrNull() ?: 4) { i ->
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
        AppTopBar("Lazy Column", onBack)

        // Hàng nhập liệu
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
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
                    if (isPositiveInt(input)) {
                        list.clear()
                        repeat(input.toInt()) { i ->
                            list.add(i + 1)
                        }
                    } else {
                        scope.launch {
                            snack.showSnackbar("Vui lòng nhập số hợp lệ")
                        }
                    }
                }
            )
        }

        // Danh sách hiển thị
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list, key = { it }) { n ->
                RoundedItem(text = n.toString())
            }
        }

        // Snackbar hiển thị thông báo lỗi
        SnackbarHost(hostState = snack)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLazyColumn() {
    DemoLazyListTheme { LazyColumnScreen(onBack = {}) }
}

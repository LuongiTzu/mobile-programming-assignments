package com.example.demolazylist.page.multitype_click

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.R
import com.example.demolazylist.page.multitype_click.components.TypeAdItem
import com.example.demolazylist.page.multitype_click.components.TypeHeaderItem
import com.example.demolazylist.page.multitype_click.components.TypePersonItem
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

// Mô hình dữ liệu nhiều loại
sealed interface MultiItem {
    data class Header(val title: String) : MultiItem
    data class Person(val name: String, val age: Int) : MultiItem
    data class Ad(val image: Int, val caption: String) : MultiItem
}

// Màn hình chính
@Composable
fun MultiTypeListScreen(
    onBack: () -> Unit,
    openA: () -> Unit,
    openB: () -> Unit,
    openC: () -> Unit,
) {
    val data: List<MultiItem> = listOf(
        MultiItem.Header("Phần 1: Danh sách các nhân vật trong Doraemon:"),
        MultiItem.Person("Doraemon", 10),
        MultiItem.Person("Nobita", 10),
        MultiItem.Ad(R.drawable.p18, "Bạn code ngô? Tôi biết là có, nhưng không thể nào chứng minh"),
        MultiItem.Person("Jaian", 10),
        MultiItem.Person("Shizuka", 10),

        MultiItem.Header("Phần 2: Danh sách các nhân vật trong Conan:"),
        MultiItem.Person("Conan", 8),
        MultiItem.Person("Agasha", 50),
        MultiItem.Ad(R.drawable.p1, "Công ty Chóa DẠY CODE số 1 Việt Nam"),
        MultiItem.Person("Mori", 45),

        MultiItem.Header("Phần 3: Danh sách các nhân vật trong Naruto:"),
        MultiItem.Person("Naruto", 16),
        MultiItem.Person("Sasuke", 16),
        MultiItem.Ad(R.drawable.p10, "Đi học code ngay kẻo thất nghiệp"),
        MultiItem.Person("Kakashi", 30),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        AppTopBar("Multi-type & Click", onBack)

        Text(
            text = "Nhấn vào từng loại item để mở trang chi tiết tương ứng.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = data,
                key = {
                    when (it) {
                        is MultiItem.Header -> "h-${it.title}"
                        is MultiItem.Person -> "p-${it.name}"
                        is MultiItem.Ad -> "ad-${it.caption}"
                    }
                },
                contentType = {
                    when (it) {
                        is MultiItem.Header -> "header"
                        is MultiItem.Person -> "person"
                        is MultiItem.Ad -> "ad"
                    }
                }
            ) { item ->
                when (item) {
                    is MultiItem.Header -> TypeHeaderItem(
                        title = item.title,
                        onClick = { openA() }
                    )

                    is MultiItem.Person -> TypePersonItem(
                        name = item.name,
                        age = item.age,
                        onClick = { openB() }
                    )

                    is MultiItem.Ad -> TypeAdItem(
                        imageRes = item.image,
                        caption = item.caption,
                        onClick = { openC() }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewMultiTypeList() {
    DemoLazyListTheme {
        MultiTypeListScreen(
            onBack = {},
            openA = {},
            openB = {},
            openC = {}
        )
    }
}

// page/multitype_click/detail/DetailTypeBScreen.kt
package com.example.demolazylist.page.multitype_click.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun DetailTypeBScreen(onBack: () -> Unit) {
    Column {
        AppTopBar("Thông tin cơ bản của nhân vật", onBack)
        Text("Tên \n Tuổi \n Giới tính \n Phim xuất hiện")
    }
}
@Preview @Composable
private fun PreviewB(){ DemoLazyListTheme{ DetailTypeBScreen({}) } }

// page/multitype_click/detail/DetailTypeAScreen.kt
package com.example.demolazylist.page.multitype_click.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun DetailTypeAScreen(onBack: () -> Unit) {
    Column {
        AppTopBar(" Đây là tiêu đề", onBack)
        Text(" Nội dung này nói về phim .........")
    }
}
@Preview @Composable
private fun PreviewA(){ DemoLazyListTheme{ DetailTypeAScreen({}) } }

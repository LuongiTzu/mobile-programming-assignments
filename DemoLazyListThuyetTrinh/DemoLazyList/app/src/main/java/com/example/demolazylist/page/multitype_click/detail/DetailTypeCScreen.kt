// page/multitype_click/detail/DetailTypeCScreen.kt
package com.example.demolazylist.page.multitype_click.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun DetailTypeCScreen(onBack: () -> Unit) {
    Column {
        AppTopBar("Quảng cáo", onBack)
        Text("  Đây là quảng cáo để giúp trang kiếm thêm tí cá!!!!")
    }
}
@Preview @Composable
private fun PreviewC(){ DemoLazyListTheme{ DetailTypeCScreen({}) } }

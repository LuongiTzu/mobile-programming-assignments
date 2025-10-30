package com.example.demolazylist.page.addtolayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demolazylist.ui.common.RoundedItem
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun BasicListItem(text: String) {
    RoundedItem(text)
}

@Preview
@Composable
private fun PreviewBasicItem() {
    DemoLazyListTheme { BasicListItem("Item demo") }
}

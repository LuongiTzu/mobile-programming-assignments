package com.example.demolazylist.page.multitype_click.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.R
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun TypeAdItem(imageRes: Int, caption: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .border(2.dp, Color(0xFFFF8A80), shape = RectangleShape)
            .background(Color(0xFFFFEBEE), shape = RectangleShape)
            .clickable { onClick() },
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = caption,
            modifier = Modifier.height(160.dp).fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = caption, modifier = Modifier.padding(top = 4.dp), color=Color.Red)
    }
}

@Preview
@Composable
private fun PreviewAd() {
    DemoLazyListTheme { TypeAdItem(R.drawable.p1, "Quảng cáo", {}) }
}

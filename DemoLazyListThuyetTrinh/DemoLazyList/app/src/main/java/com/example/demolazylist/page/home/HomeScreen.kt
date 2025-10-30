package com.example.demolazylist.page.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demolazylist.ui.common.PrimaryButton
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun HomeScreen(
    toAddBasics: () -> Unit,
    toLazyColumn: () -> Unit,
    toLazyRow: () -> Unit,
    toMultiType: () -> Unit,
    toCrud: () -> Unit,
    toGrid: () -> Unit,
    toScroll2D: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tiêu đề
        Text(
            text = "Demo Lazy List",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Các nút chiếm toàn chiều ngang, cao đều
        PrimaryButton(
            text = "Cách thêm",
            onClick = toAddBasics,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "Lazy Column",
            onClick = toLazyColumn,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "Lazy Row",
            onClick = toLazyRow,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "Xử lí click & Multi-type",
            onClick = toMultiType,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "CRUD + Swipe + Sticky Header",
            onClick = toCrud,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "LazyVerticalStaggeredGrid",
            onClick = toGrid,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
        PrimaryButton(
            text = "Nested Lazy Lists",
            onClick = toScroll2D,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHome() {
    DemoLazyListTheme {
        HomeScreen({}, {}, {}, {}, {}, {}, {})
    }
}

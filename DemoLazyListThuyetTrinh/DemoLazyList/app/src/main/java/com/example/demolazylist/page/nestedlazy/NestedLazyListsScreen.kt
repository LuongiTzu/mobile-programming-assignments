package com.example.demolazylist.page.nestedlazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NestedLazyListsScreen(onBack: () -> Unit) {
    // Kích thước lưới
    val rows = 40
    val cols = 40

    // Cache window cho trục NGANG (LazyRow): prefetch 3 cột phía trước, giữ 1.5 cột phía sau (tương đối theo viewport)
    val rowCache = remember { LazyLayoutCacheWindow(aheadFraction = 3f, behindFraction = 1.5f) }
    val rowState: LazyListState = rememberLazyListState(cacheWindow = rowCache)

    androidx.compose.foundation.layout.Column {
        AppTopBar("Nested Lazy Lists (LazyRow ⟷ LazyColumn + CacheWindow)", onBack)

        LazyRow(
            modifier = Modifier.fillMaxSize(),
            state = rowState,
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Danh sách index cột [0, 1, ..., cols-1]
            items((0 until cols).toList(), key = { it }) { c ->
                // Cache window cho trục DỌC (mỗi LazyColumn):
                // prefetch khoảng 2 màn hình phía trước, giữ 1 màn hình phía sau (theo viewport dọc của từng cột)
                val colCache = remember(c) { LazyLayoutCacheWindow(aheadFraction = 2f, behindFraction = 1f) }
                val colState = rememberLazyListState(cacheWindow = colCache)

                LazyColumn(
                    modifier = Modifier, // có thể thêm .width(72.dp) nếu muốn cột cố định
                    state = colState,
                    contentPadding = PaddingValues(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Header của cột (tùy chọn)
                    item(key = "h_$c") {
                        ColumnHeader(colIndex = c)
                        Divider()
                    }

                    // Các ô dữ liệu theo hàng (trong cột)
                    itemsIndexed(
                        items = (0 until rows).toList(),
                        key = { r, _ -> "r_${c}_$r" } // key ổn định theo (cột, hàng)
                    ) { r, _ ->
                        val n = r * cols + c + 1 // Số thứ tự trong lưới
                        NumberCell(
                            n = n,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun ColumnHeader(colIndex: Int) {
    NumberCell(
        n = colIndex + 1,
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTwoD() {
    DemoLazyListTheme { NestedLazyListsScreen({}) }
}

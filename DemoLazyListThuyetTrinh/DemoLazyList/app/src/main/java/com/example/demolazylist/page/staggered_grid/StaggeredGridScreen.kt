package com.example.demolazylist.page.staggered_grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.R
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@Composable
fun StaggeredGridScreen(onBack: () -> Unit) {
    val images = listOf(
        R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
        R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10,
        R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15,
        R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20,
        R.drawable.p21, R.drawable.p22, R.drawable.p23
    )

    val heights = listOf(180.dp, 240.dp, 200.dp, 260.dp, 160.dp)

    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar("LazyVerticalStaggeredGrid", onBack)

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 160.dp),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalItemSpacing = 12.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            items(images, key = { it }) { res ->
                val idx = images.indexOf(res)
                val h = heights[idx % heights.size]

                PhotoCard(
                    resId = res,
                    height = h
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGrid() {
    DemoLazyListTheme { StaggeredGridScreen(onBack = {}) }
}

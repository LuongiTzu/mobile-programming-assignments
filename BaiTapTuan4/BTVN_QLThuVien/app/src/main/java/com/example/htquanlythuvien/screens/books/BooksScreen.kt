package com.example.htquanlythuvien.screens.books

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BooksScreen(vm: BooksViewModel = viewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    val greyPanel = Color(0xFFE6E6E6)
    val greenStatus = Color(0xFF117A37)
    val redStatus = Color(0xFFA0183C)

    Column(
        Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(greyPanel, RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            items(state.books) { b ->
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${b.title} ${if (b.available) "(sẵn sàng)" else "(đã hết)"}",
                        modifier = Modifier.padding(12.dp),
                        color = if (b.available) greenStatus else redStatus
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Books Preview (VM)")
@Composable
private fun BooksPreview() {
    BooksScreen()
}

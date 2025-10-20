/*
package com.example.htquanlythuvien.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class BookUi(val id: String, val title: String, val available: Boolean)

@Composable
fun BooksScreen() {
    val books = remember {
        listOf(
            BookUi("b1", "Sách 01", true),
            BookUi("b2", "Sách 02", true),
            BookUi("b3", "Sách 03", false),
            BookUi("b4", "Sách 04", true),
        )
    }

    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Danh sách sách trong thư viện")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(books) { b ->
                Card(Modifier.fillMaxWidth()) {
                    Text(
                        text = "${b.title} ${if (b.available) "(sẵn sàng)" else "(đang mượn)"}",
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Books Preview")
@Composable
private fun BooksPreview() {
    BooksScreen()
}
*/

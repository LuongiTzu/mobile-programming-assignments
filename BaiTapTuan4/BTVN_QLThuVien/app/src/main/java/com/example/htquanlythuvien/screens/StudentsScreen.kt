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

private data class StudentUi(val id: String, val name: String)

@Composable
fun StudentsScreen() {
    val students = remember {
        listOf(
            StudentUi("s1", "Nguyen Van A"),
            StudentUi("s2", "Nguyen Thi B"),
            StudentUi("s3", "Nguyen Van C"),
        )
    }

    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Danh sách sinh viên")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(students) { s ->
                Card(Modifier.fillMaxWidth()) {
                    Text(text = "${s.name} (${s.id})", modifier = Modifier.padding(12.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Students Preview")
@Composable
private fun StudentsPreview() {
    StudentsScreen()
}
*/

/*
package com.example.htquanlythuvien.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.htquanlythuvien.components.BookUi
import com.example.htquanlythuvien.components.EmptyState
import com.example.htquanlythuvien.components.StudentUi
import com.example.htquanlythuvien.data.FakeData
import com.example.htquanlythuvien.data.model.Book
import com.example.htquanlythuvien.data.model.Student
@Composable
fun ManagementScreen() {
    var selectedStudent by remember { mutableStateOf(StudentUi("s1", "Nguyen Van A")) }
//    val students = remember {
//        listOf(
//            StudentUi("s1", "Nguyen Van A"),
//            StudentUi("s2", "Nguyen Thi B"),
//            StudentUi("s3", "Nguyen Van C"),
//        )
//    }
//    val books = remember {
//        listOf(
//            BookUi("b1", "Sách 01", true),
//            BookUi("b2", "Sách 02", true),
//            BookUi("b3", "Sách 03", false),
//        )
//    }
    val students = FakeData.students.map { StudentUi(it.id, it.name) }
    val books = FakeData.books.map { BookUi(it.id, it.title, it.available) }
    var checkedIds by remember { mutableStateOf(setOf<String>()) }
    var message by remember { mutableStateOf<String?>(null) }

    val Blue = Color(0xFF1E63C6)
    val GreyPanel = Color(0xFFE2E2E2)
    val CheckMaroon = Color(0xFFA0183C)

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // ===== Tiêu đề section =====
        Text("Sinh viên", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        // Ô nhập + nút Thay đổi (outline xanh, nền trắng)
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedStudent.name,
                onValueChange = {},
                readOnly = true,
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    val idx = students.indexOfFirst { it.id == selectedStudent.id }
                    selectedStudent = students[(idx + 1) % students.size]
                },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Blue),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                modifier = Modifier.height(46.dp)
            ) {
                Text("Thay đổi", fontSize = 16.sp)
            }
        }

        // ===== Danh sách sách =====
        Text("Danh sách sách", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        if (books.isEmpty()) {
            EmptyState(
                title = "Bạn chưa mượn quyển sách nào",
                description = "Nhấn 'Thêm' để bắt đầu hành trình đọc sách!"
            )
        } else {
            // Khung xám bo góc, giống ảnh
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GreyPanel, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(books) { b ->
                        // “Pill” trắng bo tròn, có bóng nhẹ
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = checkedIds.contains(b.id),
                                    onCheckedChange = {
                                        checkedIds = checkedIds.toMutableSet().apply {
                                            if (contains(b.id)) remove(b.id) else add(b.id)
                                        }
                                    },
                                    enabled = b.available,
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = CheckMaroon,
                                        uncheckedColor = Color.Gray,
                                        checkmarkColor = Color.White
                                    )
                                )
                                Text(b.title + if (!b.available) " (đang mượn)" else "")
                            }
                        }
                    }
                }
            }
        }

        // Nút “Thêm” xanh dương, căn giữa, bo tròn
        Spacer(Modifier.height(4.dp))
        Button(
            onClick = {
                message = if (checkedIds.isEmpty()) "Chưa chọn sách nào"
                else "Đã thêm ${checkedIds.size} sách cho ${selectedStudent.name}"
            },
            colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.White),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.6f)
                .height(50.dp)
        ) {
            Text("Thêm", fontSize = 16.sp)
        }

        message?.let { Text(it, modifier = Modifier.align(Alignment.CenterHorizontally)) }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Management Preview")
@Composable
private fun ManagementPreview() {
    ManagementScreen()
}
*/

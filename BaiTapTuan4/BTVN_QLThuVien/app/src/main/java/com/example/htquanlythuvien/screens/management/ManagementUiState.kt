package com.example.htquanlythuvien.screens.management

import com.example.htquanlythuvien.data.model.Book
import com.example.htquanlythuvien.data.model.Student

data class ManagementUiState(
    val students: List<Student> = emptyList(),
    val selectedStudent: Student? = null,

    // Sách SV hiện đang mượn (hiển thị trên trang chính)
    val borrowed: List<Book> = emptyList(),

    // Danh sách sách có thể thêm (chưa mượn bởi SV này)
    val availableToAdd: List<Book> = emptyList(),

    // Popup chọn sách
    val isPickerOpen: Boolean = false,
    val selectedToAdd: Set<String> = emptySet(),

    // Thông điệp ngắn
    val message: String? = null
)

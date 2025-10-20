package com.example.htquanlythuvien.data.model
import org.threeten.bp.Instant

/** Thực thể sách (đơn giản cho bài tập) */
data class Book(
    val id: String,
    val title: String,
    val available: Boolean = true
)

/** Thực thể sinh viên */
data class Student(
    val id: String,
    val name: String
)

/** (để dành) Lịch sử mượn sách – dùng khi bạn muốn nâng cấp tính năng */
data class BorrowRecord(
    val id: String,
    val studentId: String,
    val bookId: String,
    val borrowedAt: Instant = Instant.now(),
    val returnedAt: Instant? = null
)

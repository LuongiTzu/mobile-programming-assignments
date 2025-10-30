package com.example.htquanlythuvien.data.model
import org.threeten.bp.Instant

/** Thực thể sách */
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

/**Lịch sử mượn sách */
data class BorrowRecord(
    val id: String,
    val studentId: String,
    val bookId: String,
    val borrowedAt: Instant = Instant.now(),
    val returnedAt: Instant? = null
)

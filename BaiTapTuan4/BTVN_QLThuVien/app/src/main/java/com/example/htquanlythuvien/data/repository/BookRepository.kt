package com.example.htquanlythuvien.data.repository

import com.example.htquanlythuvien.data.model.Book

interface BookRepository {
    fun getAll(): List<Book>
    fun getBorrowedByStudent(studentId: String): List<Book>
    fun getAvailableForStudent(studentId: String): List<Book>
    fun borrowBooks(studentId: String, bookIds: List<String>)
    fun returnBook(studentId: String, bookId: String)
}

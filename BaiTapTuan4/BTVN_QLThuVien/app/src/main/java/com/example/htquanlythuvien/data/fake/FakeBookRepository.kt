package com.example.htquanlythuvien.data.fake

import com.example.htquanlythuvien.data.model.Book
import com.example.htquanlythuvien.data.repository.BookRepository

class FakeBookRepository : BookRepository {
    private val store get() = InMemoryStore

    /** Tập bookId đang bị mượn bởi BẤT KỲ sinh viên nào */
    private fun allBorrowedIds(): Set<String> =
        store.borrowedByStudent.values.flatten().toSet()

    override fun getAll(): List<Book> = store.books.toList()

    override fun getBorrowedByStudent(studentId: String): List<Book> {
        val ids = store.borrowedByStudent[studentId] ?: emptySet()
        return store.books.filter { it.id in ids }
    }

    /**
     * Chỉ trả về sách:
     *   - chưa bị mượn bởi ai (toàn cục)
     *   - và có cờ available == true
     */
    override fun getAvailableForStudent(studentId: String): List<Book> {
        val borrowedGlobal = allBorrowedIds()
        return store.books.filter { it.available && it.id !in borrowedGlobal }
    }

    /**
     * Mượn chỉ những cuốn đang thỏa điều kiện available==true và chưa bị mượn.
     * Các id không hợp lệ bị bỏ qua.
     */
    override fun borrowBooks(studentId: String, bookIds: List<String>) {
        val borrowedGlobal = allBorrowedIds()
        val allowed = store.books
            .filter { it.available && it.id in bookIds && it.id !in borrowedGlobal }
            .map { it.id }

        if (allowed.isEmpty()) return

        val set = store.borrowedByStudent.getOrPut(studentId) { mutableSetOf() }
        set += allowed
    }

    override fun returnBook(studentId: String, bookId: String) {
        store.borrowedByStudent[studentId]?.remove(bookId)
    }
}

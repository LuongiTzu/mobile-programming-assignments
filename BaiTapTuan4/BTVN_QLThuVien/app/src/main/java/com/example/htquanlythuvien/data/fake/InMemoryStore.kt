package com.example.htquanlythuvien.data.fake

import com.example.htquanlythuvien.data.model.Book
import com.example.htquanlythuvien.data.model.Student

/**
 * Kho dữ liệu trong bộ nhớ (giả lập DB).
 * Repo giả sẽ đọc/ghi trên đây.
 */
object InMemoryStore {
    val students = mutableListOf(
        Student("s1", "Doraemon"),
        Student("s2", "Songoku"),
        Student("s3", "Monkey D. Luffy"),
        Student("s4", "Naruto Uzumaki"),
        Student("s5", "Conan Edogawa"),
        Student("s6", "Harry Potter"),
        Student("s7", "Iron Man"),
        Student("s8", "Spider-Man"),
        Student("s9", "Pikachu"),
        Student("s10", "Rambo"),
    )

    val books = mutableListOf(
        Book("b1", "Dế Mèn Phiêu Lưu Ký", true),
        Book("b2", "One Piece - Tập 1", true),
        Book("b3", "Số Đỏ", false),
        Book("b4", "Harry Potter và Hòn Đá Phù Thủy", true),
        Book("b5", "Naruto - Tập 10", true),
        Book("b6", "Chí Phèo", true),
        Book("b7", "Thám Tử Lừng Danh Conan - Tập 20", true),
        Book("b8", "Nhà Giả Kim", true),
        Book("b9", "Tắt Đèn", false),
        Book("b10", "Attack on Titan - Tập 5", true),
        Book("b11", "Kính Vạn Hoa - Tập 1", true),
        Book("b12", "Đắc Nhân Tâm", true),
        Book("b13", "Doraemon - Tập 3", true),
        Book("b14", "Tôi Thấy Hoa Vàng Trên Cỏ Xanh", true),
        Book("b15", "Sherlock Holmes Toàn Tập", true),
        Book("b16", "Sự Im Lặng Của Bầy Cừu", false),
        Book("b17", "Bảy Viên Ngọc Rồng", true),
        Book("b18", "Truyện Kiều", true),
        Book("b19", "Lão Hạc", true),
        Book("b20", "Rừng Na Uy", true)
    )

    /** studentId -> set(bookId) đang mượn */
    val borrowedByStudent = mutableMapOf(
        "s1" to mutableSetOf("b1", "b2"),
        "s2" to mutableSetOf("b1"),
        // "s3" chưa mượn
    )
}

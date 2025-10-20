/*
package com.example.htquanlythuvien.screens.management

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.FakeData
import com.example.htquanlythuvien.data.model.Book
import com.example.htquanlythuvien.data.model.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ManagementViewModel : ViewModel() {

    // Giả lập “bảng mượn”: studentId -> set(bookId)
    private val borrowedByStudent: MutableMap<String, MutableSet<String>> = mutableMapOf(
        "s1" to mutableSetOf("b1", "b2"), // A: Sách 01, 02
        "s2" to mutableSetOf("b1"),       // B: Sách 01
        // "s3" -> chưa mượn: để trống
    )

    private val _ui = MutableStateFlow(
        ManagementUiState(
            students = FakeData.students,
            selectedStudent = FakeData.students.firstOrNull()
        )
    )
    val uiState: StateFlow<ManagementUiState> = _ui

    init {
        // đồng bộ lần đầu
        refreshLists()
    }

    */
/* ----------------- Actions ----------------- *//*


    fun nextStudent() {
        val students = _ui.value.students
        val cur = _ui.value.selectedStudent ?: return
        if (students.isEmpty()) return
        val idx = students.indexOf(cur)
        _ui.value = _ui.value.copy(
            selectedStudent = students[(idx + 1) % students.size],
            message = null
        )
        refreshLists()
    }

    fun openPicker() {
        _ui.value = _ui.value.copy(isPickerOpen = true, selectedToAdd = emptySet())
    }

    fun closePicker() {
        _ui.value = _ui.value.copy(isPickerOpen = false, selectedToAdd = emptySet())
    }

    fun toggleSelectToAdd(bookId: String) {
        val set = _ui.value.selectedToAdd.toMutableSet()
        if (!set.add(bookId)) set.remove(bookId)
        _ui.value = _ui.value.copy(selectedToAdd = set)
    }

    fun confirmAdd() {
        val studentId = _ui.value.selectedStudent?.id ?: return
        val chosen = _ui.value.selectedToAdd
        if (chosen.isEmpty()) {
            _ui.value = _ui.value.copy(message = "Chưa chọn sách nào")
            closePicker()
            return
        }
        val set = borrowedByStudent.getOrPut(studentId) { mutableSetOf() }
        set += chosen
        _ui.value = _ui.value.copy(
            message = "Đã thêm ${chosen.size} sách cho ${_ui.value.selectedStudent?.name}"
        )
        closePicker()
        refreshLists()
    }

    fun returnBook(bookId: String) {
        val studentId = _ui.value.selectedStudent?.id ?: return
        borrowedByStudent[studentId]?.remove(bookId)
        _ui.value = _ui.value.copy(message = "Đã trả sách")
        refreshLists()
    }

    */
/* ----------------- Helpers ----------------- *//*


    private fun refreshLists() {
        val studentId = _ui.value.selectedStudent?.id ?: return
        val allBooks = FakeData.books
        val borrowedIds = borrowedByStudent[studentId] ?: emptySet()

        val borrowed = allBooks.filter { it.id in borrowedIds }
        val available = allBooks.filter { it.id !in borrowedIds }

        _ui.value = _ui.value.copy(
            borrowed = borrowed,
            availableToAdd = available
        )
    }
}
*/
///lần 2:
package com.example.htquanlythuvien.screens.management

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.repository.BookRepository
import com.example.htquanlythuvien.data.repository.StudentRepository
import com.example.htquanlythuvien.di.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ManagementViewModel(
    private val bookRepo: BookRepository = ServiceLocator.bookRepo,
    private val studentRepo: StudentRepository = ServiceLocator.studentRepo
) : ViewModel() {

    private val _ui = MutableStateFlow(
        ManagementUiState(
            students = studentRepo.getAll(),
            selectedStudent = studentRepo.getFirstOrNull()
        )
    )
    val uiState: StateFlow<ManagementUiState> = _ui

    init { refreshLists() }

    fun nextStudent() {
        val list = _ui.value.students
        val cur = _ui.value.selectedStudent ?: return
        if (list.isEmpty()) return
        val idx = list.indexOf(cur)
        _ui.value = _ui.value.copy(selectedStudent = list[(idx + 1) % list.size], message = null)
        refreshLists()
    }

    fun openPicker() {
        _ui.value = _ui.value.copy(isPickerOpen = true, selectedToAdd = emptySet())
    }
    fun closePicker() {
        _ui.value = _ui.value.copy(isPickerOpen = false, selectedToAdd = emptySet())
    }

    fun toggleSelectToAdd(bookId: String) {
        val set = _ui.value.selectedToAdd.toMutableSet()
        if (!set.add(bookId)) set.remove(bookId)
        _ui.value = _ui.value.copy(selectedToAdd = set)
    }

    fun confirmAdd() {
        val sId = _ui.value.selectedStudent?.id ?: return
        val chosen = _ui.value.selectedToAdd
        if (chosen.isEmpty()) {
            _ui.value = _ui.value.copy(message = "Chưa chọn sách nào")
            closePicker()
            return
        }
        bookRepo.borrowBooks(sId, chosen.toList())
        _ui.value = _ui.value.copy(message = "Đã thêm ${chosen.size} sách cho ${_ui.value.selectedStudent?.name}")
        closePicker()
        refreshLists()
    }

    fun returnBook(bookId: String) {
        val sId = _ui.value.selectedStudent?.id ?: return
        bookRepo.returnBook(sId, bookId)
        _ui.value = _ui.value.copy(message = "Đã trả sách")
        refreshLists()
    }

    private fun refreshLists() {
        val sId = _ui.value.selectedStudent?.id ?: return
        _ui.value = _ui.value.copy(
            borrowed = bookRepo.getBorrowedByStudent(sId),
            availableToAdd = bookRepo.getAvailableForStudent(sId)
        )
    }
}

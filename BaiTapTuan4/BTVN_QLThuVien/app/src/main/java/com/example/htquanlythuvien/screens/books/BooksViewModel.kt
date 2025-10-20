/*
package com.example.htquanlythuvien.screens.books

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.FakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BooksViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BooksUiState(FakeData.books))
    val uiState: StateFlow<BooksUiState> = _uiState
}
*/
///lần 2
package com.example.htquanlythuvien.screens.books

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.repository.BookRepository
import com.example.htquanlythuvien.di.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BooksViewModel(
    private val bookRepo: BookRepository = ServiceLocator.bookRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        BooksUiState(
            books = bookRepo.getAll()
        )
    )
    val uiState: StateFlow<BooksUiState> = _uiState
}

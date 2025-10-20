/*
package com.example.htquanlythuvien.screens.students

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.FakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StudentsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(StudentsUiState(FakeData.students))
    val uiState: StateFlow<StudentsUiState> = _uiState
}
*/
///lần 2:
package com.example.htquanlythuvien.screens.students

import androidx.lifecycle.ViewModel
import com.example.htquanlythuvien.data.repository.StudentRepository
import com.example.htquanlythuvien.di.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StudentsViewModel(
    private val studentRepo: StudentRepository = ServiceLocator.studentRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        StudentsUiState(
            students = studentRepo.getAll()
        )
    )
    val uiState: StateFlow<StudentsUiState> = _uiState
}

package com.example.htquanlythuvien.data.fake

import com.example.htquanlythuvien.data.model.Student
import com.example.htquanlythuvien.data.repository.StudentRepository

class FakeStudentRepository : StudentRepository {
    private val store get() = InMemoryStore
    override fun getAll(): List<Student> = store.students.toList()
    override fun getFirstOrNull(): Student? = store.students.firstOrNull()
}

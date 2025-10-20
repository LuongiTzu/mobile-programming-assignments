package com.example.htquanlythuvien.di

import com.example.htquanlythuvien.data.fake.FakeBookRepository
import com.example.htquanlythuvien.data.fake.FakeStudentRepository
import com.example.htquanlythuvien.data.repository.BookRepository
import com.example.htquanlythuvien.data.repository.StudentRepository

object ServiceLocator {
    val bookRepo: BookRepository by lazy { FakeBookRepository() }
    val studentRepo: StudentRepository by lazy { FakeStudentRepository() }
}

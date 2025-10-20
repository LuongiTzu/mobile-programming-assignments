package com.example.htquanlythuvien.data.repository

import com.example.htquanlythuvien.data.model.Student

interface StudentRepository {
    fun getAll(): List<Student>
    fun getFirstOrNull(): Student?
}

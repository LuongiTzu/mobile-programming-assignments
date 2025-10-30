package com.example.demolazylist.util

fun isPositiveInt(text: String): Boolean =
    text.isNotBlank() && text.all { it.isDigit() } && text.toIntOrNull()?.let { it >= 0 } == true

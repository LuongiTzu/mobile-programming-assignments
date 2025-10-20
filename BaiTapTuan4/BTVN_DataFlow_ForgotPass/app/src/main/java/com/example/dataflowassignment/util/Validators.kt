package com.example.dataflowassignment.util

import android.util.Patterns

object Validators {
    fun isValidEmail(s: String) = Patterns.EMAIL_ADDRESS.matcher(s).matches()
    fun isValidOtp(s: String) = s.isNotBlank() && s.length <= 5 && s.all { it.isDigit() }
    fun isStrongPassword(s: String): Boolean =
        s.length >= 8 && s.any { it.isUpperCase() } &&
                s.any { it.isLowerCase() } && s.any { it.isDigit() }
}

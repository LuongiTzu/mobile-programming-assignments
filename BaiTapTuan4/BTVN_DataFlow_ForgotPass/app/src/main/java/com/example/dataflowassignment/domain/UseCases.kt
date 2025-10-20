package com.example.dataflowassignment.domain

import com.example.dataflowassignment.data.AuthRepository

class RequestResetUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String) = repo.requestPasswordReset(email)
}
class VerifyOtpUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, otp: String) = repo.verifyOtp(email, otp)
}
class UpdatePasswordUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, newPassword: String) =
        repo.updatePassword(email, newPassword)
}

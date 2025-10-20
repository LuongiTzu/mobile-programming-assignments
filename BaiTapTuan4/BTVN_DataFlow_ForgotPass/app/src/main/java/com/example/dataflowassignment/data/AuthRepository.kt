package com.example.dataflowassignment.data

import kotlinx.coroutines.delay

interface AuthRepository {
    suspend fun requestPasswordReset(email: String): Result<Unit>
    suspend fun verifyOtp(email: String, otp: String): Result<Unit>
    suspend fun updatePassword(email: String, newPassword: String): Result<Unit>
}

class FakeAuthRepository : AuthRepository {
    private val otpStore = mutableMapOf<String, String>()

    override suspend fun requestPasswordReset(email: String): Result<Unit> = runCatching {
        delay(400)
        otpStore[email] = "12345" // mock demo
    }

    override suspend fun verifyOtp(email: String, otp: String): Result<Unit> = runCatching {
        delay(300)
        // Cho pass trong demo: chấp nhận bất kỳ OTP (đã validate định dạng ở tầng ViewModel/Validators)
        // Nếu muốn kiểm tra chặt chẽ, dùng: require(otpStore[email] == otp) { "OTP sai" }
    }

    override suspend fun updatePassword(email: String, newPassword: String): Result<Unit> =
        runCatching {
            delay(300)
            otpStore.remove(email)
        }
}

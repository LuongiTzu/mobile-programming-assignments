package com.example.dataflowassignment.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dataflowassignment.data.AuthRepository
import com.example.dataflowassignment.data.FakeAuthRepository
import com.example.dataflowassignment.domain.RequestResetUseCase
import com.example.dataflowassignment.domain.UpdatePasswordUseCase
import com.example.dataflowassignment.domain.VerifyOtpUseCase
import com.example.dataflowassignment.util.Validators
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class FlowUiState(
    val email: String = "",
    val otp: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val loading: Boolean = false,
    val error: String? = null
)

data class ConfirmedInfo(
    val email: String,
    val otp: String,
    val password: String
)

class PasswordFlowViewModel(
    repo: AuthRepository = FakeAuthRepository()
) : ViewModel() {

    private val requestReset = RequestResetUseCase(repo)
    private val verifyOtp = VerifyOtpUseCase(repo)
    private val updatePass = UpdatePasswordUseCase(repo)

    var state by mutableStateOf(FlowUiState())
        private set

    // Lưu kết quả đã confirm (để hiển thị ở màn 1 sau submit)
    var lastConfirmed by mutableStateOf<ConfirmedInfo?>(null)
        private set

    fun updateEmail(v: String) { state = state.copy(email = v, error = null) }
    fun updateOtp(v: String) { state = state.copy(otp = v.take(5), error = null) } // OTP 5 chữ số
    fun updatePassword(v: String) { state = state.copy(password = v, error = null) }
    fun updateConfirmPassword(v: String) { state = state.copy(confirmPassword = v, error = null) }

    fun requestReset(onSuccess: () -> Unit) {
        val email = state.email.trim()
        if (!Validators.isValidEmail(email)) {
            state = state.copy(error = "Email không hợp lệ"); return
        }
        viewModelScope.launch {
            state = state.copy(loading = true, error = null)
            val result = requestReset(email)
            state = state.copy(loading = false)
            result.onSuccess { onSuccess() }
                .onFailure { state = state.copy(error = it.message ?: "Lỗi gửi mã") }
        }
    }

    fun verifyOtp(onSuccess: () -> Unit) {
        if (!Validators.isValidOtp(state.otp)) {
            state = state.copy(error = "OTP phải là số, tối đa 5 ký tự"); return
        }
        viewModelScope.launch {
            state = state.copy(loading = true, error = null)
            val result = verifyOtp(state.email, state.otp)
            state = state.copy(loading = false)
            result.onSuccess { onSuccess() }
                .onFailure { state = state.copy(error = it.message ?: "OTP không đúng") }
        }
    }

    fun validateLocalForConfirm(onValid: () -> Unit) {
        if (!Validators.isStrongPassword(state.password)) {
            state = state.copy(error = "Mật khẩu tối thiểu 8 ký tự, có hoa, thường và số")
            return
        }
        if (state.password != state.confirmPassword) {
            state = state.copy(error = "Xác nhận mật khẩu không khớp")
            return
        }
        onValid()
    }

    fun submitAll(onSuccess: () -> Unit) {
        viewModelScope.launch {
            state = state.copy(loading = true, error = null)
            val result = updatePass(state.email, state.password)
            delay(250) // giả lập network
            state = state.copy(loading = false)
            result.onSuccess {
                lastConfirmed = ConfirmedInfo(
                    email = state.email,
                    otp = state.otp,
                    password = state.password // lưu mật khẩu thật
                )
                // reset input để về màn 1 nhập mới
                state = FlowUiState()
                onSuccess()
            }.onFailure {
                state = state.copy(error = it.message ?: "Đổi mật khẩu thất bại")
            }
        }
    }
}

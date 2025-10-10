package com.example.th02_nhapmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class thongBao(
    val message: String,
    val color: Color
)
//Hàm logic xử lí dữ liệu
fun xacDinhChuanEmail(email: String): thongBao {
    val emailChuan = email.trim() //trim() để loại bỏ khoảng trắng ở đầu và cuối email
    return when {
        emailChuan.isEmpty() -> thongBao(
            message = "mail không hợp lệ",
            color = Color.Red
        )
        !emailChuan.contains("@") -> thongBao(
            message = "Email không đúng định dạng",
            color = Color.Red
        )
        else -> thongBao(
            message = "Bạn đã nhập email hợp lệ",
            color = Color.Green
        )
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManHinhNhapMail()
        }
    }
}


@Composable
fun ManHinhNhapMail() {
    // State 1: Lưu giá trị email đang được nhập
    var emailInput by rememberSaveable { mutableStateOf("") }
    // State 2: Lưu trạng thái của thông báo
    var khoiThongBao by remember {
        mutableStateOf(thongBao("Nhấn 'Kiểm tra' để xem kết quả", Color.Gray))
    }

    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding() // Xử lý tràn viền tốt hơn padding tĩnh
            .padding(horizontal = 24.dp), // Chỉ cần padding ngang
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        AppTitle()
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))
        EmailInputField(
            email = emailInput,
            onEmailChange = { emailInput = it }
        )
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(12.dp))
        ThongBaoLoi(state = khoiThongBao)
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))
        KiemTraButton(
            onClick = {
                // Khi nhấn nút, gọi hàm logic và cập nhật state
                khoiThongBao = xacDinhChuanEmail(emailInput)
            }
        )
    }
}

// text tiêu đề
@androidx.compose.runtime.Composable
fun AppTitle() {
    androidx.compose.material3.Text(
        text = "Thực hành 02",
        style = androidx.compose.material3.MaterialTheme.typography.headlineSmall, // Dùng style từ Theme
        fontWeight = FontWeight.Bold
    )
}

//ô email
@androidx.compose.runtime.Composable
fun EmailInputField(email: String, onEmailChange: (String) -> Unit) {
    androidx.compose.material3.OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { androidx.compose.material3.Text("Email") },
        placeholder = { androidx.compose.material3.Text("Nhập địa chỉ email của bạn") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@androidx.compose.runtime.Composable
fun ThongBaoLoi(state: thongBao) {
    androidx.compose.material3.Text(
        text = state.message,
        color = state.color,
        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.fillMaxWidth()
    )
}

// nút kiểm tra
@androidx.compose.runtime.Composable
fun KiemTraButton(onClick: () -> Unit) {
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)    ) {
        androidx.compose.material3.Text("Kiểm tra")
    }
}


@Preview(showBackground = true)
@androidx.compose.runtime.Composable
fun DefaultPreview() {
    MaterialTheme {
        ManHinhNhapMail()
    }
}

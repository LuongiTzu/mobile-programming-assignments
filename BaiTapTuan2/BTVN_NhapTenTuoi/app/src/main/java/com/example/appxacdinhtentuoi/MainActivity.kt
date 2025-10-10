package com.example.appxacdinhtentuoi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class KetQuaXacMinh(
    val message: String,
    val color: Color,
    val hienThiCard: Boolean = false,
    val phanLoaiTuoi: String? = null
)
fun xacDinhNhapHopLe(ten: String, tuoi: String): KetQuaXacMinh {
    val tenChuan = ten.trim()
    val tuoiChuan = tuoi.trim().toIntOrNull()

    return when {
        tuoiChuan == null || tuoiChuan <= 0 -> KetQuaXacMinh(
            message = "Tuổi không hợp lệ (phải là số lớn hơn 0).",
            color = Color.Red
        )
        tenChuan.isEmpty() || !tenChuan.matches(Regex("^[a-zA-ZÀ-ỹ ]+$")) -> KetQuaXacMinh(
            message = "Tên không hợp lệ (chỉ chứa chữ cái và dấu).",
            color = Color.Red
        )
        else -> {
            val phanLoai = when {
                tuoiChuan > 65 -> "Người già"
                tuoiChuan >= 6 -> "Người lớn"
                tuoiChuan >= 2 -> "Trẻ em"
                else -> "Em bé"
            }
            KetQuaXacMinh(
                message = "Xác thực thành công!",
                color = Color.Green,
                hienThiCard = true,
                phanLoaiTuoi = phanLoai
            )
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ManHinhNhapTenTuoi()
                }
            }
        }
    }
}

@Composable
fun ManHinhNhapTenTuoi() {
    var nameInput by rememberSaveable { mutableStateOf("") }
    var ageInput by rememberSaveable { mutableStateOf("") }
    var ketQua by remember {
        mutableStateOf(KetQuaXacMinh("Nhấn 'Kiểm tra' để xem kết quả", Color.Gray))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Kiểm Tra Thông Tin",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))

        InputField(
            ten = nameInput,
            tuoi = ageInput,
            onDoiTen = { nameInput = it },
            onDoiTuoi = { ageInput = it }
        )
        Spacer(modifier = Modifier.height(24.dp))

        KiemTraButton(
            onClick = {
                ketQua = xacDinhNhapHopLe(nameInput, ageInput)
            }
        )
        Spacer(modifier = Modifier.height(24.dp))

        if (ketQua.message != "Nhấn 'Kiểm tra' để xem kết quả") {
            if (ketQua.hienThiCard && ketQua.phanLoaiTuoi != null) {
                ThongTinNguoiDungCard(
                    ten = nameInput,
                    tuoi = ageInput,
                    phanLoai = ketQua.phanLoaiTuoi!!
                )
            } else {
                ThongBaoLoi(state = ketQua)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ThongTinNguoiDungCard(ten: String, tuoi: String, phanLoai: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Thông tin người dùng",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row {
                Text("Họ và tên:", fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(0.4f))
                Text(ten, modifier = Modifier.weight(0.6f))
            }
            Row {
                Text("Tuổi:", fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(0.4f))
                Text(tuoi, modifier = Modifier.weight(0.6f))
            }
            Row {
                Text("Phân loại:", fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(0.4f))
                Text(
                    text = phanLoai,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00796B),
                    modifier = Modifier.weight(0.6f)
                )
            }
        }
    }
}

@Composable
fun InputField(ten: String, tuoi: String, onDoiTen: (String) -> Unit, onDoiTuoi: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Họ và tên:",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.4f)
                )
                OutlinedTextField(
                    value = ten,
                    onValueChange = onDoiTen,
                    modifier = Modifier.weight(0.6f),
                    placeholder = { Text("Nhập tên") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tuổi:",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.4f)
                )
                OutlinedTextField(
                    value = tuoi,
                    onValueChange = onDoiTuoi,
                    modifier = Modifier.weight(0.6f),
                    placeholder = { Text("Nhập tuổi") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun ThongBaoLoi(state: KetQuaXacMinh) {
    Text(
        text = state.message,
        color = state.color,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}
@Composable
fun KiemTraButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text("Kiểm tra")
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ManHinhNhapTenTuoi()
    }
}

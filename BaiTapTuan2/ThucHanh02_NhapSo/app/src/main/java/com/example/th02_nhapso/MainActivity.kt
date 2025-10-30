package com.example.th02_nhapso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ManHinhNhapSo()
                }
            }
        }
    }
}

@Composable
fun ManHinhNhapSo() {
    var duLieu by rememberSaveable { mutableStateOf("") }
    var hienThiThongBao by remember { mutableStateOf(false) }
    var thongBaoLoi by remember { mutableStateOf("Dữ liệu bạn nhập không hợp lệ") }
    var soHangSinh by remember { mutableStateOf<List<Int>>(emptyList()) }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val MAX_ITEMS = 500

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 250.dp), // Khoảng cách trên
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Thực hành 02",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = duLieu,
                onValueChange = { duLieu = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Nhập vào số lượng") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = {
                    val n = duLieu.trim().toIntOrNull()// Xóa khoảng trắng và cố gắng chuyển đổi sang số nguyên hoặc null
                    when {
                        n == null || n <= 0 -> {
                            thongBaoLoi = "Dữ liệu bạn nhập không hợp lệ"
                            hienThiThongBao = true
                        }
                        n > MAX_ITEMS -> {
                            thongBaoLoi = "Số quá lớn. Tối đa $MAX_ITEMS."
                            hienThiThongBao = true
                        }
                        else -> {
                            hienThiThongBao = false
                            soHangSinh = (1..n).toList()
                            keyboardController?.hide()
                            focusManager.clearFocus()

                            coroutineScope.launch {
                                if (soHangSinh.isNotEmpty()) {
                                    listState.animateScrollToItem(0)
                                }
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = Modifier.height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Tạo", color = Color.White)
            }
        }

        if (hienThiThongBao) {
            Text(
                text = thongBaoLoi,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp, start = 16.dp),
                fontSize = 14.sp
            )
        } else {
            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Chiếm hết không gian dọc còn lại
        ) {
            if (soHangSinh.isNotEmpty()) {
                LazyColumn(
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(soHangSinh) { num ->
                        NumberItem(number = num)
                    }
                }
            }
        }
    }
}

@Composable
fun NumberItem(number: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Red),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "$number",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ManHinhNhapSo()
    }
}

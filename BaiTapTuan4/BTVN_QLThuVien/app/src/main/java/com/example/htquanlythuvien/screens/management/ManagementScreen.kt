package com.example.htquanlythuvien.screens.management

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagementScreen(
    vm: ManagementViewModel = viewModel()
) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    val Blue = Color(0xFF1E63C6)
    val GreyPanel = Color(0xFFE2E2E2)
    val CheckMaroon = Color(0xFFA0183C)

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("Sinh viên", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = state.selectedStudent?.name.orEmpty(),
                onValueChange = {},
                readOnly = true,
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { vm.nextStudent() },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Blue),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Blue
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                modifier = Modifier.height(46.dp)
            ) { Text("Thay đổi", fontSize = 16.sp) }
        }

        Text("Danh sách sách", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        // Khung xám hiển thị sách đã mượn của sinh viên
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreyPanel, RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            if (state.borrowed.isEmpty()) {
                // Empty state giống ảnh
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text("Bạn chưa mượn quyển sách nào. Nhấn 'Thêm' để bắt đầu hành trình đọc sách!")
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(state.borrowed) { b ->
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(b.title, modifier = Modifier.weight(1f))
                                TextButton(onClick = { vm.returnBook(b.id) }) {
                                    Text("Trả")
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(4.dp))
        Button(
            onClick = { vm.openPicker() },
            colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.White),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.6f)
                .height(50.dp)
        ) { Text("Thêm", fontSize = 16.sp) }

        state.message?.let { Text(it, modifier = Modifier.align(Alignment.CenterHorizontally)) }
    }

    /* ---------- Modal bottom sheet: chọn sách để thêm ---------- */
    if (state.isPickerOpen) {
        PickerSheet(state = state, vm = vm)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PickerSheet(
    state: ManagementUiState,
    vm: ManagementViewModel
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = { vm.closePicker() },
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()   // tránh bị che bởi 3-button bar
                .imePadding()              // tránh bàn phím
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Chọn sách để thêm", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

            if (state.availableToAdd.isEmpty()) {
                Text("Không còn sách khả dụng.")
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f, fill = true) // chiếm phần còn lại
                ) {
                    items(state.availableToAdd) { b ->
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = state.selectedToAdd.contains(b.id),
                                    onCheckedChange = { vm.toggleSelectToAdd(b.id) },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFFA0183C),
                                        uncheckedColor = Color.Gray,
                                        checkmarkColor = Color.White
                                    )
                                )
                                Text(text = b.title)
                            }
                        }
                    }
                }
            }

            Button(
                onClick = { vm.confirmAdd() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) { Text("Xác nhận") }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Management (Borrow view + picker)")
@Composable
private fun ManagementPreview() {
    ManagementScreen()
}

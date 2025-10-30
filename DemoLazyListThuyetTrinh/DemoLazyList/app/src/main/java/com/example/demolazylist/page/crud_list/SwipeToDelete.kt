package com.example.demolazylist.page.crud_list

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.common.PrimaryButton
import com.example.demolazylist.ui.theme.DemoLazyListTheme
import kotlinx.coroutines.launch
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeToDelScreen(onBack: () -> Unit) {
    var newName by remember { mutableStateOf("") }
    val list = remember {
        mutableStateListOf(
            // 20 nhân vật One Piece
            "Monkey D. Luffy",
            "Roronoa Zoro",
            "Nami",
            "Usopp",
            "Vinsmoke Sanji",
            "Tony Tony Chopper",
            "Nico Robin",
            "Franky",
            "Brook",
            "Jinbe",
            "Portgas D. Ace",
            "Sabo",
            "Trafalgar Law",
            "Shanks",
            "Dracule Mihawk",
            "Edward Newgate (Râu Trắng)",
            "Kaido",
            "Charlotte Linlin (Big Mom)",
            "Marshall D. Teach (Râu Đen)",
            "Gol D. Roger",

            // 20 nhân vật Dragon Ball
            "Son Goku",
            "Vegeta",
            "Son Gohan",
            "Piccolo",
            "Krillin",
            "Yamcha",
            "Tenshinhan",
            "Bulma",
            "Chi-Chi",
            "Master Roshi (Quy Lão Kame)",
            "Trunks",
            "Frieza",
            "Cell",
            "Majin Buu",
            "Beerus",
            "Whis",
            "Android 18",
            "Android 17",
            "Goten",
            "Mr. Satan"
        )
    }

    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AppTopBar("CRUD + Swipe + Sticky Header", onBack)

        OutlinedTextField(
            value = newName,
            onValueChange = { newName = it },
            label = { Text("Nhập tên nhân vật") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PrimaryButton(
                "Thêm đầu",
                {
                    if (newName.isNotBlank()) {
                        list.add(0, newName.trim())
                        newName = ""
                    }
                },
                Modifier.weight(1f)
            )
            PrimaryButton(
                "Thêm giữa",
                {
                    if (newName.isNotBlank()) {
                        val mid = list.size / 2
                        list.add(mid, newName.trim())
                        newName = ""
                    }
                },
                Modifier.weight(1f)
            )
            PrimaryButton(
                "Thêm cuối",
                {
                    if (newName.isNotBlank()) {
                        list.add(newName.trim())
                        newName = ""
                    }
                },
                Modifier.weight(1f)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            stickyHeader {
                Surface(tonalElevation = 2.dp, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Danh sách nhân vật",
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }

            itemsIndexed(list, key = { _, item -> item }) { index, name ->
                SwipeableItem(
                    text = name,
                    onSwiped = {
                        scope.launch {
                            list.removeAt(index)
                        }
                    },
                    onEdit = {
                        list[index] = "$name (updated)"
                    }
                )
            }
        }
    }
}

@Composable
fun SwipeableItem(
    text: String,
    onSwiped: () -> Unit,
    onEdit: () -> Unit
) {
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val threshold = 300f // Ngưỡng cần kéo để xóa
    var dismissed by remember { mutableStateOf(false) }
    // Khi true,  item sẽ không còn được vẽ (ẩn khỏi giao diện)
    if (!dismissed) { //Nếu chưa xoá, hiển thị item
        Box(
            modifier = Modifier.fillMaxWidth().background(Color(0xFFFFEBEE)).pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        // Khi người dùng thả tay (kết thúc vuốt)
                        onDragEnd = {
                            scope.launch {
                                // Nếu độ lệch ngang lớn hơn ngưỡng xoá
                                if (abs(offsetX.value) > threshold) {
                                    // Vuốt đủ xa → Xoá item
                                    offsetX.animateTo(//// Animate item trượt ra khỏi màn hình
                                        targetValue = if (offsetX.value > 0) 1000f else -1000f,
                                        animationSpec = tween(300)
                                    )
                                    dismissed = true
                                    onSwiped()
                                } else {
                                    // Không đủ xa → trả về vị trí ban đầu
                                    offsetX.animateTo(0f,
                                        tween(300))
                                }
                            }
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            scope.launch {
                                offsetX.snapTo(offsetX.value + dragAmount)
                            }
                        }
                    )
                }
        ) {
            // Icon xoá nền
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = if (offsetX.value > 0) Arrangement.Start else Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Xoá",
                    tint = Color.Red
                )
            }

            // Nội dung item
            Box(
                modifier = Modifier
                    .offset { androidx.compose.ui.unit.IntOffset(offsetX.value.toInt(), 0) }
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCrudCustomSwipe() {
    DemoLazyListTheme { SwipeToDelScreen ({}) }
}

package com.example.demolazylist.page.crud_list

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demolazylist.ui.common.AppTopBar
import com.example.demolazylist.ui.common.PrimaryButton
import com.example.demolazylist.ui.theme.DemoLazyListTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CrudListScreen(onBack: () -> Unit) {
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

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        AppTopBar("CRUD + Swipe + Sticky", onBack)

        OutlinedTextField(
            value = newName,
            onValueChange = { newName = it },
            label = { Text("Nhập tên nhân vật") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        // Nút thêm
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PrimaryButton(
                text = "Thêm đầu",
                onClick = {
                    if (newName.isNotBlank()) {
                        list.add(0, newName.trim())
                        newName = ""
                    }
                },
                modifier = Modifier.weight(1f)
            )

            PrimaryButton(
                text = "Thêm giữa",
                onClick = {
                    if (newName.isNotBlank()) {
                        val middleIndex = list.size / 2
                        list.add(middleIndex, newName.trim())
                        newName = ""
                    }
                },
                modifier = Modifier.weight(1f)
            )

            PrimaryButton(
                text = "Thêm cuối",
                onClick = {
                    if (newName.isNotBlank()) {
                        list.add(newName.trim())
                        newName = ""
                    }
                },
                modifier = Modifier.weight(1f)
            )

        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            //tiêu đề dính
            stickyHeader {
                Surface(tonalElevation = 2.dp, modifier = Modifier.fillMaxWidth()) {
                    Text("Danh sách nhân vật", modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.titleSmall)
                }
            }
            itemsIndexed(list, key = { _, name -> name }) { _, name ->
                val currentItem by rememberUpdatedState(name)

                val dismissState = rememberSwipeToDismissBoxState(
                    confirmValueChange = { v ->
                        if (v == SwipeToDismissBoxValue.StartToEnd || v == SwipeToDismissBoxValue.EndToStart) {
                            list.remove(currentItem)
                        }
                        true
                    }
                )
                //vuốt để xóa
                SwipeToDismissBox(
                    state = dismissState,
                    enableDismissFromStartToEnd = true,
                    enableDismissFromEndToStart = true,
                    // Nền CHỈ hiển thị khi không ở trạng thái Default
                    backgroundContent = {
                        val target = dismissState.targetValue
                        val align = when (dismissState.dismissDirection) {
                            SwipeToDismissBoxValue.StartToEnd -> Alignment.CenterStart
                            SwipeToDismissBoxValue.EndToStart -> Alignment.CenterEnd
                            else -> Alignment.CenterEnd
                        }
                    }
                    ,
                    content = {
                        CharacterRow(
                            name = name,
                            onEdit = {
                                val idx = list.indexOf(currentItem)
                                if (idx != -1) list[idx] = "$currentItem (updated)"
                            },
                            onDelete = { list.remove(currentItem) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCrud() {
    DemoLazyListTheme { CrudListScreen({}) }
}



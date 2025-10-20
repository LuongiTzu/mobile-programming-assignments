package com.example.htquanlythuvien.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String) {
    CenterAlignedTopAppBar(title = { Text(text = title) })
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header(title = "Hệ thống Quản lý Thư viện")
}

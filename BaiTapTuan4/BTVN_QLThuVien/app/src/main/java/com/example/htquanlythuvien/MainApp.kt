package com.example.htquanlythuvien

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.htquanlythuvien.components.BottomBar
import com.example.htquanlythuvien.components.Header
import com.example.htquanlythuvien.navigation.AppNavHost
import com.example.htquanlythuvien.navigation.Routes
import com.example.htquanlythuvien.ui.theme.HTQuanLyThuVienTheme

@Composable
fun MainApp() {
    HTQuanLyThuVienTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route ?: Routes.Management

        Scaffold(
            topBar = { Header(title = "Hệ thống Quản lý Thư viện") },
            bottomBar = { BottomBar(navController = navController, currentRoute = currentRoute) },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "MainApp Preview")
@Composable
private fun MainAppPreview() {
    MainApp()
}

package com.example.htquanlythuvien.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.htquanlythuvien.navigation.Routes

@Composable
fun BottomBar(
    navController: NavHostController,
    currentRoute: String
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == Routes.Management,
            onClick = {
                if (currentRoute != Routes.Management) {
                    navController.navigate(Routes.Management) {
                        popUpTo(Routes.Management) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Quản lý") },
            label = { Text("Quản lý") }
        )
        NavigationBarItem(
            selected = currentRoute == Routes.Books,
            onClick = {
                if (currentRoute != Routes.Books) {
                    navController.navigate(Routes.Books) {
                        popUpTo(Routes.Management) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Filled.LibraryBooks, contentDescription = "DS Sách") },
            label = { Text("DS Sách") }
        )
        NavigationBarItem(
            selected = currentRoute == Routes.Students,
            onClick = {
                if (currentRoute != Routes.Students) {
                    navController.navigate(Routes.Students) {
                        popUpTo(Routes.Management) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Sinh viên") },
            label = { Text("Sinh viên") }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarPreview() {
    val nav = rememberNavController()
    BottomBar(navController = nav, currentRoute = Routes.Management)
}

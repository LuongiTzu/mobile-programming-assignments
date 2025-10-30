package com.example.htquanlythuvien.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.htquanlythuvien.screens.books.BooksScreen
import com.example.htquanlythuvien.screens.management.ManagementScreen
import com.example.htquanlythuvien.screens.students.StudentsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Management,
        modifier = modifier
    ) {
        composable(Routes.Management) { ManagementScreen() }
        composable(Routes.Books) { BooksScreen() }
        composable(Routes.Students) { StudentsScreen() }
    }
}



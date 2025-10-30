package com.example.demolazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.demolazylist.navigation.AppNavGraph
import com.example.demolazylist.ui.theme.DemoLazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoLazyListTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavGraph() // Toàn bộ điều hướng + các màn hình demo
                }
            }
        }
    }
}

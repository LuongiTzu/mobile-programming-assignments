package com.example.dataflowassignment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.dataflowassignment.navigation.AppNavGraph
import com.example.dataflowassignment.presentation.PasswordFlowViewModel
import com.example.dataflowassignment.ui.theme.DataFlowAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataFlowAssignmentTheme {
                val vm: PasswordFlowViewModel = viewModel()
                AppNavGraph(viewModel = vm)
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppPreview() {
    // Preview toàn bộ ứng dụng (hiển thị Splash → Onboarding đầu tiên)
    DataFlowAssignmentTheme {
        val nav = rememberNavController()
        AppNavGraph(viewModel = PasswordFlowViewModel())
    }
}
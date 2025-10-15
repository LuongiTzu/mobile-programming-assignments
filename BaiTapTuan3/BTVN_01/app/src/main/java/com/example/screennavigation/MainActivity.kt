package com.example.screennavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.screennavigation.layout.ComponentScreen
import com.example.screennavigation.layout.ImageScreen
import com.example.screennavigation.layout.RowLayoutScreen
import com.example.screennavigation.layout.TextFieldScreen
import com.example.screennavigation.layout.TextScreen
import com.example.screennavigation.layout.WelcomeScreen
import com.example.screennavigation.ui.theme.ScreenNavigationTheme

object Routes {
    const val welcome = "welcomescreen"
    const val components = "componentscreen"
    const val textDetail = "textscreen"
    const val imageDetail = "imagescreen"
    const val textFieldDetail = "textfieldscreen"
    const val rowLayout = "rowscreen"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenNavigationTheme { AppNavigation() }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.welcome) {
        composable(Routes.welcome) {
            WelcomeScreen(onReady = { navController.navigate(Routes.components) })
        }
        composable(Routes.components) {
            ComponentScreen(
                onOpenTextDetail = { navController.navigate(Routes.textDetail) },
                onBack = { navController.popBackStack() },
                onOpenImage = { navController.navigate(Routes.imageDetail) },
                onOpenTextField = { navController.navigate(Routes.textFieldDetail) },
                onOpenRowLayout = { navController.navigate(Routes.rowLayout) }
            )
        }
        composable(Routes.textDetail) {
            TextScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.imageDetail) {
            ImageScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.textFieldDetail) {
            TextFieldScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.rowLayout) {
            RowLayoutScreen(onBack = { navController.popBackStack() })
        }
    }
}

/* ---------- Preview ---------- */
@Preview(showBackground = true, name = "App Navigation Preview")
@Composable
fun AppNavigationPreview() {
    ScreenNavigationTheme { AppNavigation() }
}

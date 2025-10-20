package com.example.dataflowassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dataflowassignment.presentation.PasswordFlowViewModel
import com.example.dataflowassignment.screens.ConfirmScreen
import com.example.dataflowassignment.screens.ForgotPasswordScreen
import com.example.dataflowassignment.screens.ResetPasswordScreen
import com.example.dataflowassignment.screens.VerifyCodeScreen

@Composable
fun AppNavGraph(viewModel: PasswordFlowViewModel) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = NavRoutes.FORGOT) {

        composable(NavRoutes.FORGOT) {
            ForgotPasswordScreen(
                state = viewModel.state,
                lastConfirm = viewModel.lastConfirmed,
                onEmailChange = viewModel::updateEmail,
                onNext = {
                    viewModel.requestReset(
                        onSuccess = { nav.navigate(NavRoutes.VERIFY) }
                    )
                }
            )
        }

        composable(NavRoutes.VERIFY) {
            VerifyCodeScreen(
                state = viewModel.state,
                onBack = { nav.popBackStack() },
                onOtpChange = viewModel::updateOtp,
                onNext = {
                    viewModel.verifyOtp(
                        onSuccess = { nav.navigate(NavRoutes.RESET) }
                    )
                }
            )
        }

        composable(NavRoutes.RESET) {
            ResetPasswordScreen(
                state = viewModel.state,
                onBack = { nav.popBackStack() },
                onPasswordChange = viewModel::updatePassword,
                onConfirmPasswordChange = viewModel::updateConfirmPassword,
                onNext = {
                    viewModel.validateLocalForConfirm(
                        onValid = { nav.navigate(NavRoutes.CONFIRM) }
                    )
                }
            )
        }

        composable(NavRoutes.CONFIRM) {
            ConfirmScreen(
                state = viewModel.state,
                onBack = { nav.popBackStack() },
                onSubmit = {
                    viewModel.submitAll(
                        onSuccess = {
                            // Quay về màn 1 và giữ kết quả confirm để hiển thị
                            nav.popBackStack(NavRoutes.FORGOT, inclusive = false)
                            nav.navigate(NavRoutes.FORGOT) {
                                popUpTo(NavRoutes.FORGOT) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            )
        }
    }
}

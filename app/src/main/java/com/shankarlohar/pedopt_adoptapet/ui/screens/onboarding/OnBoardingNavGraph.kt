package com.shankarlohar.pedopt_adoptapet.ui.screens.onboarding

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shankarlohar.pedopt_adoptapet.ui.navigation.EdenAppNavigationRoutes
import com.shankarlohar.pedopt_adoptapet.ui.navigation.OnBoardingNavigationRoutes
import com.shankarlohar.pedopt_adoptapet.utils.LogInViewModelFactory
import com.shankarlohar.pedopt_adoptapet.utils.SignUpViewModelFactory
import com.shankarlohar.pedopt_adoptapet.viewmodels.EdenLogInViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.onBoardingNavGraph(
    navController: NavController,
    route: String,
    signUpViewModelFactory: SignUpViewModelFactory,
    logInViewModelFactory: LogInViewModelFactory
) {

    navigation(route = route, startDestination = OnBoardingNavigationRoutes.welcomeScreenRoute) {
        composable(OnBoardingNavigationRoutes.welcomeScreenRoute) {
            WelcomeScreen(
                onCreateAccountButtonClick = { navController.navigate(OnBoardingNavigationRoutes.signUpScreenRoute) },
                onLoginButtonClick = { navController.navigate(OnBoardingNavigationRoutes.loginScreenRoute) }
            )
        }
        composable(OnBoardingNavigationRoutes.signUpScreenRoute) {
            SignUpScreen(
                viewModel = viewModel(
                    viewModelStoreOwner = it,
                    factory = signUpViewModelFactory
                ),
                onAccountCreatedSuccessfully = { navigateToHomeScreen(navController) }
            )
        }
        composable(OnBoardingNavigationRoutes.loginScreenRoute) {
            LoginScreen(
                viewModel = viewModel<EdenLogInViewModel>(
                    viewModelStoreOwner = it,
                    factory = logInViewModelFactory
                ),
                onSuccessfulAuthentication = { navigateToHomeScreen(navController) }
            )
        }
    }
}

private fun navigateToHomeScreen(navController: NavController) {
    navController.navigate(EdenAppNavigationRoutes.homeScreenRoute) {
        popUpTo(OnBoardingNavigationRoutes.welcomeScreenRoute) { inclusive = true }
    }
}
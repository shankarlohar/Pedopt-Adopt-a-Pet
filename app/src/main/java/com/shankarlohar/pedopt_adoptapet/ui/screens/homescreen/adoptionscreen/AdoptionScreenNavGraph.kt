package com.shankarlohar.pedopt_adoptapet.ui.screens.homescreen.adoptionscreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shankarlohar.pedopt_adoptapet.data.domain.PetInfo
import com.shankarlohar.pedopt_adoptapet.ui.navigation.AdoptionScreenNavigationRoutes
import com.shankarlohar.pedopt_adoptapet.utils.AdoptionScreenViewModelFactory
import com.shankarlohar.pedopt_adoptapet.viewmodels.EdenAdoptionScreenViewModel


@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.adoptionScreenGraph(
    navController: NavController,
    route: String,
    adoptionScreenViewModelFactory: AdoptionScreenViewModelFactory,
) {
    navigation(route = route, startDestination = AdoptionScreenNavigationRoutes.homeScreenRoute) {
        composable(route = AdoptionScreenNavigationRoutes.homeScreenRoute) {
            AdoptionScreen(
                viewmodel = viewModel(it, factory = adoptionScreenViewModelFactory),
                onItemClicked = { selectedPetInfo ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("a", selectedPetInfo)
                    navController.navigate(AdoptionScreenNavigationRoutes.detailsScreenRoute)
                }
            )
        }
        composable(route = AdoptionScreenNavigationRoutes.detailsScreenRoute) {
            navController.previousBackStackEntry?.savedStateHandle?.get<PetInfo>("a")
                ?.let { selectedPet ->
                    DetailsScreen(
                        viewModel = viewModel<EdenAdoptionScreenViewModel>(factory = adoptionScreenViewModelFactory),
                        petInfo = selectedPet
                    )
                }
        }
    }
}
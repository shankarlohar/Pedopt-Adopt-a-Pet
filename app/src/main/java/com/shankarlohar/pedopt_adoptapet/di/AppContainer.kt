package com.shankarlohar.pedopt_adoptapet.di

import com.shankarlohar.pedopt_adoptapet.auth.AuthenticationService
import com.shankarlohar.pedopt_adoptapet.auth.FirebaseAuthenticationService
import com.shankarlohar.pedopt_adoptapet.data.PedoptRepository
import com.shankarlohar.pedopt_adoptapet.data.Repository
import com.shankarlohar.pedopt_adoptapet.data.remote.FirebaseRemoteDatabase
import com.shankarlohar.pedopt_adoptapet.utils.*
import kotlinx.coroutines.Dispatchers

class AppContainer {
    private val defaultDispatcher = Dispatchers.IO

    val authenticationService = FirebaseAuthenticationService() as AuthenticationService

    //repository
    private val remoteDatabase = FirebaseRemoteDatabase()
    private val repository = PedoptRepository(remoteDatabase) as Repository

    // viewmodel factories TODO Fix - All viewModel factories will be kept in memory until the application is killed.
    val loginViewModelFactory = LogInViewModelFactory(authenticationService, defaultDispatcher)
    val signUpViewModelFactory = SignUpViewModelFactory(authenticationService, defaultDispatcher)
    val adoptionScreenViewModelFactory = AdoptionScreenViewModelFactory(repository, authenticationService, defaultDispatcher)
    val notificationScreenViewModelFactory = NotificationScreenViewModelFactory(repository,authenticationService)
    val reportScreenViewModelFactory = ReportsScreenViewModelFactory(repository,authenticationService,defaultDispatcher)
}
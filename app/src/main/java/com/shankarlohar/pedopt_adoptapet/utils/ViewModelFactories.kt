package com.shankarlohar.pedopt_adoptapet.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shankarlohar.pedopt_adoptapet.auth.AuthenticationService
import com.shankarlohar.pedopt_adoptapet.data.Repository
import com.shankarlohar.pedopt_adoptapet.viewmodels.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LogInViewModelFactory(
    private val authenticationService: AuthenticationService,
    private val defaultDispatcher: CoroutineDispatcher,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        EdenLogInViewModel(authenticationService, defaultDispatcher) as T
}

class SignUpViewModelFactory(
    private val authenticationService: AuthenticationService,
    private val defaultDispatcher: CoroutineDispatcher,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        EdenSignUpViewModel(authenticationService, defaultDispatcher) as T

}

class AdoptionScreenViewModelFactory(
    private val repository: Repository,
    private val authenticationService: AuthenticationService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        EdenAdoptionScreenViewModel(repository, authenticationService, defaultDispatcher) as T
}

class NotificationScreenViewModelFactory(
    private val repository: Repository,
    private val authenticationService: AuthenticationService
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        EdenNotificationsScreenViewmodel(repository, authenticationService) as T
}

class ReportsScreenViewModelFactory(
    private val repository: Repository,
    private val authenticationService: AuthenticationService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        EdenReportScreenViewModel(repository, authenticationService, defaultDispatcher) as T
    }
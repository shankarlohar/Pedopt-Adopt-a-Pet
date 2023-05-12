package com.shankarlohar.pedopt_adoptapet.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shankarlohar.pedopt_adoptapet.auth.AuthenticationService
import com.shankarlohar.pedopt_adoptapet.data.Repository
import com.shankarlohar.pedopt_adoptapet.data.domain.NotificationInfo

/**
 * An interface that consists of all the fields and methods required
 * for a NotificaationsScreenViewModel.
 */
interface NotificationsScreenViewModel {
    val notificationList: LiveData<List<NotificationInfo>>
}

class EdenNotificationsScreenViewmodel(
    repository: Repository,
    authenticationService: AuthenticationService
) : ViewModel(), NotificationsScreenViewModel {

    //TODO(Remove non-null assertion)
    override val notificationList: LiveData<List<NotificationInfo>> =
        repository.listenForNotifications(authenticationService.currentUser!!)


}

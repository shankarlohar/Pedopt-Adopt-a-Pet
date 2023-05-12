package com.shankarlohar.pedopt_adoptapet.data

import androidx.lifecycle.LiveData
import com.shankarlohar.pedopt_adoptapet.data.domain.PedoptUser
import com.shankarlohar.pedopt_adoptapet.data.domain.IncidentReportInfo
import com.shankarlohar.pedopt_adoptapet.data.domain.NotificationInfo
import com.shankarlohar.pedopt_adoptapet.data.domain.PetInfo
import com.shankarlohar.pedopt_adoptapet.data.remote.RemoteDatabase

/**
 * An interface that consists of all the fields and methods required
 * for the repository.
 */
interface Repository {
    val petsAvailableForAdoption: LiveData<List<PetInfo>>

    /**
     * Used to get a [LiveData] that contains a list of all
     * [NotificationInfo] objects related to the [currentUser].
     * Any updates to the underlying Firebase collection will
     * be automatically reflected in the Livedata, in real time.
     */
    fun listenForNotifications(currentUser: PedoptUser): LiveData<List<NotificationInfo>>

    /**
     * Used to raise a request to adopt a pet by the [user].
     * @param petInfo contains the details of the pet to be
     * adopted.
     */
    suspend fun sendRequestForAdoption(user: PedoptUser, petInfo: PetInfo)

    /**
     * Used to save an incident report with the provided [user]
     * and [IncidentReportInfo].
     */
    suspend fun sendIncidentReport(user: PedoptUser, reportInfo: IncidentReportInfo)
}

class PedoptRepository(
    private val remoteDatabase: RemoteDatabase
) : Repository {
    override val petsAvailableForAdoption: LiveData<List<PetInfo>> =
        remoteDatabase.petsAvailableForAdoption

    override fun listenForNotifications(currentUser: PedoptUser) =
        remoteDatabase.listenForNotifications(currentUser)

    override suspend fun sendRequestForAdoption(user: PedoptUser, petInfo: PetInfo) {
        remoteDatabase.sendRequestForAdoption(user.id, petInfo.id)
    }

    override suspend fun sendIncidentReport(user: PedoptUser, reportInfo: IncidentReportInfo) {
        if (user.email == null) throw IllegalStateException("Incident report not sent. User email is null.")
        else remoteDatabase.saveIncidentReport(user.id, user.email, reportInfo)
    }
}
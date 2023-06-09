package com.shankarlohar.pedopt_adoptapet.data.domain

import android.net.Uri

/**
 * A domain model class that represents a user with a [name],
 * [email] and a [photoUrl] that will be used as the profile
 * picture of the user.
 */
data class PedoptUser(
    val id:String,
    val name: String?,
    val email: String?,
    val photoUrl: Uri?
)
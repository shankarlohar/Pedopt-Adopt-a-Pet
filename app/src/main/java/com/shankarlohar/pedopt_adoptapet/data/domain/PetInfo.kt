package com.shankarlohar.pedopt_adoptapet.data.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URL

/**
 * This class is used to depict the entire profile of a pet.
 */
@Parcelize
data class PetInfo(
    val id:String,
    val name:String,
    val age:String,
    val color:String,
    val weight:String,
    val description:String,
    val type:String,
    val breed:String,
    val gender:String,
    val imageResource:String
):Parcelable

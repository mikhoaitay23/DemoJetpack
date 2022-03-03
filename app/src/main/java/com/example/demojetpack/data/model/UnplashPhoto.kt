package com.example.demojetpack.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnplashPhoto(
    val id: String,
    val description: String,
    val user: UserUnplash,
    val urls: UrlsUnplash
) : Parcelable {
    @Parcelize
    data class UrlsUnplash(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable

    @Parcelize
    data class UserUnplash(
        val name: String,
        val userName: String
    ) : Parcelable
}

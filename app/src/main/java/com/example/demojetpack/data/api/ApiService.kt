package com.example.demojetpack.data.api

import com.example.demojetpack.data.model.PhotoResponse
import com.example.demojetpack.data.model.UnplashPhoto
import com.example.demojetpack.utils.Constants
import retrofit2.http.*

interface ApiService {

    @Headers("Accept-Version: v1", "Authorization: Client-ID ${Constants.ACCESS_KEY}")
    @GET("search/photos")
    suspend fun getPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): PhotoResponse
}
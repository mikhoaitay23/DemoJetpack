package com.example.demojetpack.data.repository

import android.app.Application
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.demojetpack.data.api.RetrofitService
import com.example.demojetpack.data.model.UnplashPhoto
import com.example.demojetpack.ui.screen.home.paging.UnplashPagingSource
import kotlinx.coroutines.flow.Flow

class UnplashRepository(private val application: Application) {

    fun getPhotos(query: String): Flow<PagingData<UnplashPhoto>> =
        Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = true),
            pagingSourceFactory = { UnplashPagingSource(RetrofitService.apiService, query) }
        ).flow

}
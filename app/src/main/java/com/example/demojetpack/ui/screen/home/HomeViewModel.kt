package com.example.demojetpack.ui.screen.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.demojetpack.data.model.UnplashPhoto
import com.example.demojetpack.data.repository.UnplashRepository
import kotlinx.coroutines.flow.Flow

class HomeViewModel(val application: Application) : ViewModel() {

    private val repository = UnplashRepository(application)

    init {

    }

    fun getPhotos(): Flow<PagingData<UnplashPhoto>> = repository.getPhotos(QUERY).cachedIn(viewModelScope)

    class Factory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    companion object {
        const val QUERY = "cats"
    }
}
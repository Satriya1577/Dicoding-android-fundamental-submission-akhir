package com.example.mydicoding.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mydicoding.data.remote.EventRepository
import com.example.mydicoding.di.Injection
import com.example.mydicoding.ui.navigation.detail.DetailViewModel
import com.example.mydicoding.ui.navigation.favorite.FavoriteViewModel
import com.example.mydicoding.ui.navigation.finished.FinishedViewModel
import com.example.mydicoding.ui.navigation.home.HomeViewModel
import com.example.mydicoding.ui.navigation.upcoming.UpcomingViewModel

class ViewModelFactory private constructor(private val eventRepository: EventRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpcomingViewModel::class.java)) {
            return UpcomingViewModel(eventRepository) as T
        } else if (modelClass.isAssignableFrom(FinishedViewModel::class.java)) {
            return FinishedViewModel(eventRepository) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(eventRepository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(eventRepository) as T
        } else if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(eventRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}
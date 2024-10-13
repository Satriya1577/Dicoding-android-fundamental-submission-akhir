package com.example.mydicoding.ui.navigation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mydicoding.data.local.database.FavoriteEvent
import com.example.mydicoding.data.remote.EventRepository

class FavoriteViewModel(val eventRepository: EventRepository) : ViewModel() {
    fun getAllFavoriteEvent(): LiveData<List<FavoriteEvent>> = eventRepository.getAllFavoriteEvents()
}
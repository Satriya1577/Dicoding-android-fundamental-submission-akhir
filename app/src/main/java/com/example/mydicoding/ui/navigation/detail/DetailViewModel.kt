package com.example.mydicoding.ui.navigation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydicoding.data.local.database.FavoriteEvent
import com.example.mydicoding.data.remote.EventRepository
import kotlinx.coroutines.launch

class DetailViewModel(val eventRepository: EventRepository) : ViewModel() {

    fun findDetailEvents(id: String) = eventRepository.getDetailEvent(id)

    fun getFavoriteEventById(id: String): LiveData<FavoriteEvent?> = eventRepository.getFavoriteEventById(id)

    fun insertFavoriteEvent(favoriteEvent: FavoriteEvent) {
        viewModelScope.launch {
            eventRepository.insertFavoriteEvent(favoriteEvent)
        }
    }

    fun deleteFavoriteEventById(eventId: String) {
        viewModelScope.launch {
            eventRepository.deleteFavoriteEventById(eventId)
        }
    }

}
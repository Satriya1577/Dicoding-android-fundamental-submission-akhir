package com.example.mydicoding.ui.navigation.home

import androidx.lifecycle.ViewModel
import com.example.mydicoding.data.remote.EventRepository

class HomeViewModel(val eventRepository: EventRepository) : ViewModel() {

    init {
        findFiveFinishedEvents()
        findFiveUpcomingEvents()
    }

    fun findFiveFinishedEvents() = eventRepository.getFinishedEvent(true)
    fun findFiveUpcomingEvents() = eventRepository.getUpcomingEvent(true)
}
package com.example.mydicoding.ui.navigation.upcoming

import androidx.lifecycle.ViewModel
import com.example.mydicoding.data.remote.EventRepository

class UpcomingViewModel(val eventRepository: EventRepository) : ViewModel() {

    init {
        findUpcomingEvents()
    }

    fun findUpcomingEvents(keyword: String? = null) = eventRepository.getUpcomingEvent(limitFiveData = false, keyword = keyword)
}
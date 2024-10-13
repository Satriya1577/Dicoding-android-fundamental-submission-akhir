package com.example.mydicoding.ui.navigation.finished
import androidx.lifecycle.ViewModel
import com.example.mydicoding.data.remote.EventRepository

class FinishedViewModel(val eventRepository: EventRepository) : ViewModel() {
    init {
        findFinishedEvents()
    }
    fun findFinishedEvents(keyword: String? = null) = eventRepository.getFinishedEvent(limitFiveData = false, keyword = keyword)
}
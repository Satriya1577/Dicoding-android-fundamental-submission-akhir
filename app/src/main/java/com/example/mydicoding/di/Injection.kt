package com.example.mydicoding.di

import android.content.Context
import com.example.mydicoding.data.local.database.EventDatabase
import com.example.mydicoding.data.remote.EventRepository
import com.example.mydicoding.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): EventRepository {
        val apiService = ApiConfig.getApiService()
        val database = EventDatabase.getInstance(context)
        val favoriteEventDao = database.favoriteEventDao()
        val upcomingEVentDao = database.upcomingEventDao()
        val finishedEventDao = database.finishedEventDao()
        return EventRepository(apiService, favoriteEventDao, upcomingEVentDao, finishedEventDao)
    }
}
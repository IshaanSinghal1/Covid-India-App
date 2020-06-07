package com.example.india_covid19_tracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StateDataViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StateDataViewModel::class.java)) {
            return StateDataViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
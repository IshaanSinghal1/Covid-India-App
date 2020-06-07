package com.example.india_covid19_tracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.IOException

class StateDataViewModel(application: Application) : AndroidViewModel(application){
    private var _stateList=MutableLiveData<List<StatewiseItem>>()
    var statelist:LiveData<List<StatewiseItem>> =_stateList
        get()= _stateList

    private var viewModelJob=Job()
    private  var workscope= CoroutineScope(Dispatchers.Main+viewModelJob)
    init{
        responseDeliever()
    }
    fun responseDeliever() {
            workscope.launch {
            val response = withContext(Dispatchers.IO) { Client.api.clone().execute() }
            if(response.isSuccessful){
                val data = Gson().fromJson(response.body?.string(), Response::class.java)
                dataCapture(data.statewise)
            }
        }
    }
    private val _navigateToSelectedProperty = MutableLiveData<StatewiseItem>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedProperty: LiveData<StatewiseItem>
        get() = _navigateToSelectedProperty

    private fun dataCapture(list: List<StatewiseItem>) {
        _stateList.value=list
    }
    fun displayPropertyDetails(statewiseItem: StatewiseItem) {
        _navigateToSelectedProperty.value = statewiseItem
    }
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
    override fun onCleared() {
        super.onCleared()
    }
}
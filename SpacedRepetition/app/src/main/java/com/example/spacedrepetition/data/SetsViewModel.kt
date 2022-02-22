package com.example.spacedrepetition.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Sets>>
    private val repository: SetsRepository

    init {
        val setsDao = SetsDatabase.getDatabase(application).setsDao()
        repository = SetsRepository(setsDao)
        readAllData = repository.readAllData
    }
    fun addSets(sets: Sets){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSets(sets)
        }
    }
}
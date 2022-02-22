package com.example.spacedrepetition.data

import androidx.lifecycle.LiveData

class SetsRepository(private val setsDao: SetsDao) {

    val readAllData: LiveData<List<Sets>> = setsDao.readAllData()

    suspend fun addSets(sets: Sets){
        setsDao.addSets(sets)
    }
}
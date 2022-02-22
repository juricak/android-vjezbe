package com.example.spacedrepetition.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface SetsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSets(sets: Sets)

    @Query("SELECT * FROM set_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Sets>>
}
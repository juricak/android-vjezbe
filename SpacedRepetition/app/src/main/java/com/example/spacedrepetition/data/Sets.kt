package com.example.spacedrepetition.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "set_table")
data class Sets(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val setDetails: String
)
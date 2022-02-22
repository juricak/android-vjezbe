package com.example.spacedrepetition.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sets::class], version = 2, exportSchema = false)
abstract class SetsDatabase: RoomDatabase() {

    abstract fun setsDao(): SetsDao

    companion object {
        @Volatile
        private var INSTANCE: SetsDatabase? = null

        fun getDatabase(context: Context): SetsDatabase {

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SetsDatabase::class.java,
                    "sets_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
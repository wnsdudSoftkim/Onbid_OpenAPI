package com.example.onbid.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RoomData::class),version = 1,exportSchema = false)
abstract class AppDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
}
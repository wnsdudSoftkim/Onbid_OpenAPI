package com.example.onbid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCamcoDao(item: Array<out RoomData?>)
    @Query("SELECT * FROM RoomData")
    fun getCamcoDao():List<RoomData>
}
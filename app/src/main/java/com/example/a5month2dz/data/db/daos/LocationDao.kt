package com.example.a5month2dz.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a5month2dz.models.LocationModel

@Dao
interface LocationDao {

    @Query("SELECT * FROM locationmodel")
    fun getAll(): LiveData<List<LocationModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(locationModel: List<LocationModel>)
}
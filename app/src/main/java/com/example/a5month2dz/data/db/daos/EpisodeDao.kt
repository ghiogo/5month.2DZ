package com.example.a5month2dz.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a5month2dz.models.EpisodeModel

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodemodel")
    fun getAll(): LiveData<List<EpisodeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(episodeModel: List<EpisodeModel>)
}

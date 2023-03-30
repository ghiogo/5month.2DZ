package com.example.a5month2dz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.a5month2dz.data.db.daos.CharacterDao
import com.example.a5month2dz.data.db.daos.EpisodeDao
import com.example.a5month2dz.data.db.daos.LocationDao
import com.example.a5month2dz.models.CharacterModel
import com.example.a5month2dz.models.EpisodeModel
import com.example.a5month2dz.models.LocationModel
import com.example.a5month2dz.utils.CharacterConverter

@Database(
    entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class],
    version = 1
)
@TypeConverters(CharacterConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}
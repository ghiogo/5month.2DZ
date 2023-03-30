package com.example.a5month2dz.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class EpisodeModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("episode")
    val episode: String
)
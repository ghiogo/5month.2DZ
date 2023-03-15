package com.example.a5month2dz.data.models

import com.google.gson.annotations.SerializedName

class EpisodeModel(
    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("episode")
    val episode: String
)
package com.example.a5month2dz.data.model

import com.google.gson.annotations.SerializedName

class LocationModel(
    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String
)
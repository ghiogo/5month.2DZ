package com.example.a5month2dz.models

import com.google.gson.annotations.SerializedName

class LocationModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String
)
package com.example.a5month2dz.models

import com.google.gson.annotations.SerializedName

data class Info(

    @SerializedName("count")
    val count: Int,

    @SerializedName("pages")
    val pages: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("prev")
    val prev: String
)

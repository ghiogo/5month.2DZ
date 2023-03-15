package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.data.models.LocationModel
import com.example.a5month2dz.data.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}
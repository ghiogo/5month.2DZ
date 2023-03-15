package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.data.model.LocationModel
import com.example.a5month2dz.data.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService : EpisodeApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}
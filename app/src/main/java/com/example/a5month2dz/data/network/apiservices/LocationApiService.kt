package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.models.LocationModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(
//        @Query("page") page: Int
    ): Call<RickAndMortyResponse<LocationModel>>

    @GET("api/location/{id}")
    fun fetchOneLocation(
        @Path("id") id:Int
    ): Call<LocationModel>
}
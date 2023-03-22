package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.models.LocationModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
        @Query("args") page: Int
    ): RickAndMortyResponse<LocationModel>

//    @GET("api/location/{id")
//    fun fetchOneLocation(
//        @Path("id") id:Int
//    ): Call<LocationModel>
}
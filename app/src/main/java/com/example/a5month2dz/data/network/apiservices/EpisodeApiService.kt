package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.models.EpisodeModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<EpisodeModel>

//    @GET("api/episode/{id")
//    fun fetchOneEpisode(
//        @Path("id") id:Int
//    ): Call<EpisodeModel>
}
package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.data.models.EpisodeModel
import com.example.a5month2dz.data.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>
}
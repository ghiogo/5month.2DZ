package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.data.models.CharacterModel
import com.example.a5month2dz.data.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

}
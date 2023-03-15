package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.data.model.CharacterModel
import com.example.a5month2dz.data.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

}
package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.models.CharacterModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(
//        @Query("page") page: Int
    ): Call<RickAndMortyResponse<CharacterModel>>

    @GET("api/character/{id}")
    fun fetchCharacter(
        @Path("id") id:Int
    ): Call<CharacterModel>
}
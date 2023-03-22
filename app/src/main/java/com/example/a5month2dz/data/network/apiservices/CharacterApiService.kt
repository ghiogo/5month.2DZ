package com.example.a5month2dz.data.network.apiservices

import com.example.a5month2dz.models.CharacterModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("args") page: Int
    ): RickAndMortyResponse<CharacterModel>

//    @GET("api/character/{id")
//    fun fetchCharacter(
//        @Path ("id") id:Int
//    ): Call<CharacterModel>
}
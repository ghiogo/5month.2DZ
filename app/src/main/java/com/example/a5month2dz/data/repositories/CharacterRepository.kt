package com.example.a5month2dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.a5month2dz.App
import com.example.a5month2dz.data.repositories.pagingsources.CharacterPagingSources
import com.example.a5month2dz.models.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharacterRepository {

    fun fetchCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSources(App.characterApiService!!)
            }).flow
    }
}
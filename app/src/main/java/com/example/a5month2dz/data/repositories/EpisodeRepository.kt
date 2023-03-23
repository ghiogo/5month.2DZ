package com.example.a5month2dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.a5month2dz.App
import com.example.a5month2dz.data.repositories.pagingsources.EpisodePagingSources
import com.example.a5month2dz.models.EpisodeModel
import kotlinx.coroutines.flow.Flow

class EpisodeRepository {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSources(App.episodeApiService!!)
            }).flow
    }
}

//    fun fetchOneEpisode(id: Int): MutableLiveData<EpisodeModel> {
//        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
//        App.episodeApiService?.fetchOneEpisode(id)?.enqueue(object :
//            retrofit2.Callback<EpisodeModel> {
//
//            override fun onResponse(
//                call: Call<EpisodeModel>,
//                response: Response<EpisodeModel>
//            ) {
//                data.value = response.body()
//            }
//
//            override fun onFailure(
//                call: Call<EpisodeModel>,
//                t: Throwable
//            ) {
//                data.value = null
//            }
//        })
//        return data
//    }

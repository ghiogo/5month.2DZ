package com.example.a5month2dz.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a5month2dz.data.db.daos.EpisodeDao
import com.example.a5month2dz.data.network.apiservices.EpisodeApiService
import com.example.a5month2dz.models.EpisodeModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApiService: EpisodeApiService,
    private val episodeDao: EpisodeDao
) {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        episodeApiService.fetchEpisode()
            .enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> episodeDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }
                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchOneEpisode(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        episodeApiService.fetchOneEpisode(id).enqueue(object :
            Callback<EpisodeModel> {
            override fun onResponse(
                call: Call<EpisodeModel>,
                response: Response<EpisodeModel>
            ) {
                data.value = response.body()
            }
            override fun onFailure(
                call: Call<EpisodeModel>,
                t: Throwable
            ) {
                data.value = null
            }
        })
        return data
    }

    fun getAll(): LiveData<List<EpisodeModel>> {
        return episodeDao.getAll()
    }
}

//    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                EpisodePagingSources(App.episodeApiService!!)
//            }).flow
//    }
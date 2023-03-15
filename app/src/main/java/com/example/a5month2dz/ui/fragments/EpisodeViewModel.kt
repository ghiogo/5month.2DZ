package com.example.a5month2dz.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2dz.App
import com.example.a5month2dz.data.model.EpisodeModel
import com.example.a5month2dz.data.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        App.episodeApiService?.fetchEpisode()?.enqueue(object :
            retrofit2.Callback<RickAndMortyResponse<EpisodeModel>> {

            override fun onResponse(
                call: Call<RickAndMortyResponse<EpisodeModel>>,
                response: Response<RickAndMortyResponse<EpisodeModel>>
            ) {
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
}
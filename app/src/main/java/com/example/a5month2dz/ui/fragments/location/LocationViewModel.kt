package com.example.a5month2dz.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2dz.App
import com.example.a5month2dz.data.models.LocationModel
import com.example.a5month2dz.data.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        App.locationApiService?.fetchLocation()?.enqueue(object :
            retrofit2.Callback<RickAndMortyResponse<LocationModel>> {

            override fun onResponse(
                call: Call<RickAndMortyResponse<LocationModel>>,
                response: Response<RickAndMortyResponse<LocationModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(
                call: Call<RickAndMortyResponse<LocationModel>>,
                t: Throwable
            ) {
                data.value = null
            }
        })
        return data
    }
}
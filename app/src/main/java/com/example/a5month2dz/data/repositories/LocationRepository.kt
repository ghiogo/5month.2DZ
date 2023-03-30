package com.example.a5month2dz.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a5month2dz.data.db.daos.LocationDao
import com.example.a5month2dz.data.network.apiservices.LocationApiService
import com.example.a5month2dz.models.LocationModel
import com.example.a5month2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDao: LocationDao
) {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        locationApiService.fetchLocation()
            .enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> locationDao.insertAll(it1.results) }
                        }
                    }
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

    fun fetchOneLocation(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        locationApiService.fetchOneLocation(id).enqueue(object :
            Callback<LocationModel> {
            override fun onResponse(
                call: Call<LocationModel>,
                response: Response<LocationModel>
            ) {
                data.value = response.body()
            }
            override fun onFailure(
                call: Call<LocationModel>,
                t: Throwable
            ) {
                data.value = null
            }
        })
        return data
    }

    fun getAll(): LiveData<List<LocationModel>> {
        return locationDao.getAll()
    }
}
//    fun fetchLocation(): Flow<PagingData<LocationModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                LocationPagingSources(App.locationApiService!!)
//            }).flow
//    }
//}
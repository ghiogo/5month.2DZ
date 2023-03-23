package com.example.a5month2dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.a5month2dz.App
import com.example.a5month2dz.data.repositories.pagingsources.LocationPagingSources
import com.example.a5month2dz.models.LocationModel
import kotlinx.coroutines.flow.Flow

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApiService!!)
            }).flow
    }
}

//    fun fetchOneLocation(id: Int): MutableLiveData<LocationModel> {
//        val data: MutableLiveData<LocationModel> = MutableLiveData()
//        App.locationApiService?.fetchOneLocation(id)?.enqueue(object :
//            retrofit2.Callback<LocationModel>{
//
//            override fun onResponse(
//                call: Call<LocationModel>,
//                response: Response<LocationModel>
//            ) {
//                data.value = response.body()
//            }
//
//            override fun onFailure(
//                call: Call<LocationModel>,
//                t: Throwable
//            ) {
//                data.value = null
//            }
//        })
//        return data
//    }

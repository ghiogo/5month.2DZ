package com.example.a5month2dz.ui.fragments.location.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.LocationRepository
import com.example.a5month2dz.models.LocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchOneLocation(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchOneLocation(id)
    }
}

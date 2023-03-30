package com.example.a5month2dz.ui.fragments.location

import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun getAll() = locationRepository.getAll()

    fun fetchLocation() = locationRepository.fetchLocation()
}

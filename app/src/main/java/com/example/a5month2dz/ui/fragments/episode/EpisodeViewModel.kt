package com.example.a5month2dz.ui.fragments.episode

import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisode() = episodeRepository.fetchEpisode()

    fun getAll() = episodeRepository.getAll()
}


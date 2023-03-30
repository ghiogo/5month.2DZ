package com.example.a5month2dz.ui.fragments.episode.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.EpisodeRepository
import com.example.a5month2dz.models.EpisodeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchOneEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchOneEpisode(id)
    }
}
package com.example.a5month2dz.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month2dz.R
import com.example.a5month2dz.base.BaseFragment
import com.example.a5month2dz.databinding.FragmentDetailEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment
    : BaseFragment<FragmentDetailEpisodeBinding, EpisodeDetailViewModel>(R.layout.fragment_detail_episode) {

    override val binding by viewBinding(FragmentDetailEpisodeBinding::bind)
    override val viewModel: EpisodeDetailViewModel by viewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun setupObserver() {
        viewModel.fetchOneEpisode(args.id).observe(viewLifecycleOwner) {
            binding.episodeDetailAirDate.text = it.air_date
            binding.episodeDetailName.text = it.name
        }
    }
}
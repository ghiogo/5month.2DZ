package com.example.a5month2dz.ui.fragments.episode

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month2dz.R
import com.example.a5month2dz.base.BaseFragment
import com.example.a5month2dz.databinding.FragmentEpisodeBinding
import com.example.a5month2dz.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter(this::onEpisodeItemClick)

    override fun initialize() {
        binding.rvEpisode.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserver() {
        if (onlineAndOffline()) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it.results)
                Toast.makeText(requireContext(), "online", Toast.LENGTH_SHORT).show()
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it)
                Toast.makeText(requireContext(), "offline", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onlineAndOffline(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false

        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    private fun onEpisodeItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToDetailEpisodeFragment(id)
        )
    }
}

//    fun episodeOnItemClick(id: Int) {
//        findNavController().navigate(R.id.action_episodeFragment_to_detailEpisodeFragment)
//    }
package com.example.a5month2dz.ui.fragments.location

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
import com.example.a5month2dz.databinding.FragmentLocationBinding
import com.example.a5month2dz.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter(this::onLocationItemClick)

    override fun initialize() {
        binding.rvLocation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserver() {
        if (onlineAndOffline()) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it.results)
                Toast.makeText(requireContext(), "online", Toast.LENGTH_SHORT).show()
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it)
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

   private fun onLocationItemClick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationFragmentToDetailLocationFragment(id)
        )
    }
}
//    fun locationOnItemClick(id: Int) {
//        findNavController().navigate(R.id.action_locationFragment_to_detailLocationFragment)
//    }

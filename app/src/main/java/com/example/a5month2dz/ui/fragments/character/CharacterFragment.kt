package com.example.a5month2dz.ui.fragments.character

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
import com.example.a5month2dz.databinding.FragmentCharacterBinding
import com.example.a5month2dz.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    private var characterAdapter = CharacterAdapter(this::onCharacterItemClick)
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()

    override fun initialize() {
        binding.rvCharacter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserver() {
        if (onlineAndOffline()) {
            viewModel.fetchCharacters().observe(viewLifecycleOwner) {
                characterAdapter.submitList(it.results)
                Toast.makeText(requireContext(), "online", Toast.LENGTH_SHORT).show()
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                characterAdapter.submitList(it)
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

    private fun onCharacterItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailCharacterFragment(
                id
            )
        )
    }
}
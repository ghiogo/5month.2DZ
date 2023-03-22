package com.example.a5month2dz.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month2dz.R
import com.example.a5month2dz.base.BaseFragment
import com.example.a5month2dz.databinding.FragmentCharacterBinding
import com.example.a5month2dz.ui.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    private var characterAdapter = CharacterAdapter()
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()

    override fun initialize() {
        binding.rvCharacter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserver() {
        lifecycleScope.launch {
            viewModel.fetchCharacter().collect {
                characterAdapter.submitData(it)
            }
        }
    }
}
//    fun characterOnItemClick(id: Int) {
//        findNavController().navigate(R.id.action_characterFragment_to_detailCharacterFragment)
//    }

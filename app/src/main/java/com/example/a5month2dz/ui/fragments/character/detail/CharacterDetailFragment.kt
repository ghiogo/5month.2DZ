package com.example.a5month2dz.ui.fragments.character.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month2dz.R
import com.example.a5month2dz.base.BaseFragment
import com.example.a5month2dz.databinding.FragmentDetailCharacterBinding
import com.example.a5month2dz.extensions.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment
    : BaseFragment<FragmentDetailCharacterBinding, CharacterDetailViewModel>(R.layout.fragment_detail_character) {

    override val binding by viewBinding(FragmentDetailCharacterBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserver() {
        viewModel.fetchCharacter(args.id).observe(viewLifecycleOwner){
            binding.characterDetailName.text = it.name
            binding.characterDetailId.text = it.id.toString()
            binding.imageDetail.setImage(it.image)
        }
    }
}

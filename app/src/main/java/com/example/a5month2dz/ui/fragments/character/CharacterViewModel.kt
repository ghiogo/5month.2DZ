package com.example.a5month2dz.ui.fragments.character

import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun fetchCharacters() = characterRepository.fetchCharacters()

    fun getAll() = characterRepository.getAll()
}


package com.example.a5month2dz.ui.fragments.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.a5month2dz.data.repositories.CharacterRepository

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter() = characterRepository.fetchCharacters().cachedIn(viewModelScope)
}


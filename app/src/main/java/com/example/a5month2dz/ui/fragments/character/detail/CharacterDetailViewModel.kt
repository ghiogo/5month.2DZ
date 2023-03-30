package com.example.a5month2dz.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2dz.data.repositories.CharacterRepository
import com.example.a5month2dz.models.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel(){

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacter(id)
    }
}
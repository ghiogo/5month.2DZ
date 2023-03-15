package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a5month2dz.data.models.CharacterModel
import com.example.a5month2dz.databinding.ItemCharacterBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterName.text = characterModel.name
            binding.itemCharacterType.text = characterModel.type
            binding.itemCharacterId.text = characterModel.id.toString()
            Glide.with(binding.imageCharacter.context).load(characterModel.image)
                .into(binding.imageCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
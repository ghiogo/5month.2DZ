package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month2dz.models.CharacterModel
import com.example.a5month2dz.databinding.ItemCharacterBinding
import com.example.a5month2dz.extensions.setImage

class CharacterAdapter(val onCharacterItemClick: (id: Int) -> Unit) :
    ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CharacterModel?) {
            binding.itemCharacterName.text = item?.name
            binding.itemCharacterId.text = item?.id.toString()
            binding.itemCharacterType.text = item?.type
            binding.imageCharacter.setImage(item!!.image)
        }
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).let { character -> onCharacterItemClick(character.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
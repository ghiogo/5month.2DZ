package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month2dz.models.EpisodeModel
import com.example.a5month2dz.databinding.ItemEpisodeBinding

class EpisodeAdapter(val onEpisodeItemClick: (id : Int) -> Unit) : ListAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?) {
            binding.itemEpisodeName.text = item?.name
            binding.itemEpisode.text = item?.episode
            binding.itemEpisodeCreated.text = item?.created
            binding.itemEpisodeAirDate.text = item?.air_date
        }
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).let { episode -> onEpisodeItemClick(episode.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeAdapter.ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
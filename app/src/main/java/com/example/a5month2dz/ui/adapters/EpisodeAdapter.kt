package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month2dz.models.EpisodeModel
import com.example.a5month2dz.databinding.ItemEpisodeBinding

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    fun setList(list: List<EpisodeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) {
            binding.itemEpisodeName.text = episodeModel.name
            binding.itemEpisode.text = episodeModel.episode
            binding.itemEpisodeCreated.text = episodeModel.created
            binding.itemEpisodeAirDate.text = episodeModel.air_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
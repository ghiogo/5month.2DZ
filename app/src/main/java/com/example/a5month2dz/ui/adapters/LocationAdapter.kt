package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month2dz.databinding.ItemLocationBinding
import com.example.a5month2dz.models.LocationModel

class LocationAdapter(val onLocationItemClick: (id: Int) -> Unit) :
    ListAdapter<LocationModel, LocationAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LocationModel?) {
            binding.itemLocationName.text = item?.name
            binding.itemLocationType.text = item?.type
            binding.itemLocationCreated.text = item?.created
            binding.itemLocationDimension.text = item?.dimension
        }
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).let { episode ->
                    onLocationItemClick(episode.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

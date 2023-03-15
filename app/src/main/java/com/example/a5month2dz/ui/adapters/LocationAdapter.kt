package com.example.a5month2dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month2dz.data.model.LocationModel
import com.example.a5month2dz.databinding.ItemLocationBinding

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var list: List<LocationModel> = ArrayList()

    fun setList(list: List<LocationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationModel: LocationModel) {
            binding.itemLocationName.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
            binding.itemLocationCreated.text = locationModel.created
            binding.itemLocationDimension.text = locationModel.dimension
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
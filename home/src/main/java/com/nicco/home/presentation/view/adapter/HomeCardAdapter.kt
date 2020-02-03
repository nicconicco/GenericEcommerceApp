package com.nicco.home.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicco.home.databinding.ListItemHomeBinding
import com.nicco.home.presentation.model.HomeCardModel

class HomeCardAdapter : ListAdapter<HomeCardModel, RecyclerView.ViewHolder>(HomeDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlantViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    class PlantViewHolder(
        private val binding: ListItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeCardModel) {
            binding.apply {
                homeCardModel = item
                executePendingBindings()
            }
        }
    }
}

private class HomeDiffCallback : DiffUtil.ItemCallback<HomeCardModel>() {

    override fun areItemsTheSame(oldItem: HomeCardModel, newItem: HomeCardModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeCardModel, newItem: HomeCardModel): Boolean {
        return oldItem == newItem
    }
}
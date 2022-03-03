package com.example.demojetpack.ui.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demojetpack.data.model.UnplashPhoto
import com.example.demojetpack.databinding.ItemRcImageBinding

class UnplashPhotoAdapter :
    PagingDataAdapter<UnplashPhoto, UnplashPhotoAdapter.UnplashPhotoViewHolder>(
        PHOTO_COMPARATOR
    ) {

    override fun onBindViewHolder(holder: UnplashPhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnplashPhotoViewHolder {
        val binding = ItemRcImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UnplashPhotoViewHolder(binding)
    }

    inner class UnplashPhotoViewHolder(val binding: ItemRcImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: UnplashPhoto) {
            binding.photoModel = photo
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnplashPhoto>() {
            override fun areItemsTheSame(
                oldItem: UnplashPhoto,
                newItem: UnplashPhoto
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UnplashPhoto,
                newItem: UnplashPhoto
            ) = oldItem == newItem

        }
    }
}
package com.mirz.gameapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mirz.gameapp.R
import com.mirz.gameapp.databinding.ItemGameBinding
import com.mirz.gameapp.domain.entities.GameEntity
import com.mirz.gameapp.utils.BaseAdapter
import com.mirz.gameapp.utils.DiffCallbackListener
import com.mirz.gameapp.utils.convertStringDate

class GameAdapter(val listener: (GameEntity) -> Unit) :
    BaseAdapter<GameEntity, ItemGameBinding>(diffCallbackListener) {

    override fun createViewHolder(inflater: LayoutInflater, container: ViewGroup) =
        ItemGameBinding.inflate(inflater, container, false)

    override fun bind(binding: ItemGameBinding, item: GameEntity, position: Int, count: Int) {
        binding.apply {
            tvName.text = item.name
            tvRelease.text = item.releaseDate.convertStringDate()
            tvRating.text = item.rating.toString()
            Glide.with(root.context)
                .load(item.image)
                .placeholder(R.drawable.ic_baseline_image_24)
                .error(R.drawable.ic_baseline_image_24)
                .apply(
                    RequestOptions()
                        .centerCrop()
                        .override(512, 512)
                ).into(ivGame)
            root.setOnClickListener {
                listener(item)
            }
        }
    }

    companion object {
        val diffCallbackListener = object : DiffCallbackListener<GameEntity> {
            override fun areItemsTheSame(oldItem: GameEntity, newItem: GameEntity) =
                oldItem.id == newItem.id
        }
    }
}
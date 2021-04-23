package com.apprendev.instagramfake.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.data.local.entities.ExploreEntity
import com.apprendev.instagramfake.ui.adapters.viewHolder.ExploreViewHolder
import com.squareup.picasso.Picasso

class ExploreAdapter(private var data: ArrayList<ExploreEntity>): RecyclerView.Adapter<ExploreViewHolder>() {

    fun updateData(data: ArrayList<ExploreEntity>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false))
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        Picasso.get().load(data[position].image).into(holder.imgData)
    }

    override fun getItemCount(): Int = data.size

}
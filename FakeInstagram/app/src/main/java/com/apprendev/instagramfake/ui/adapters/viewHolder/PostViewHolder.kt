package com.apprendev.instagramfake.ui.adapters.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apprendev.instagramfake.R

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgPost = view.findViewById(R.id.imgPost) as ImageView
    val tvTitle = view.findViewById(R.id.tvTitle) as TextView
    val tvDescription = view.findViewById(R.id.tvDescription) as TextView
}
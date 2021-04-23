package com.apprendev.instagramfake.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.data.local.entities.PostEntity
import com.apprendev.instagramfake.ui.adapters.viewHolder.PostViewHolder
import com.apprendev.instagramfake.utils.Network
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class PostAdapter(private val context: Context, private var posts: ArrayList<PostEntity>) :
    RecyclerView.Adapter<PostViewHolder>() {

    fun updatePosts(posts: ArrayList<PostEntity>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.tvTitle.text = post.title
        holder.tvDescription.text = post.description

        if (Network.isNetworkAvailable(context)) {
            Picasso.get().load(post.image).into(holder.imgPost)

        } else {
            Picasso.get().load(post.image).networkPolicy(NetworkPolicy.OFFLINE).into(holder.imgPost)
        }

    }

    override fun getItemCount(): Int = posts.size
}
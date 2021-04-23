package com.apprendev.instagramfake.data.remote.responses

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)
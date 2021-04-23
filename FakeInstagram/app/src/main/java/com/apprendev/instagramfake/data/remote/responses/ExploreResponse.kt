package com.apprendev.instagramfake.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ExploreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String
)
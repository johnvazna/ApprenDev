package com.apprendev.instagramfake.data.remote.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val last_name: String
)

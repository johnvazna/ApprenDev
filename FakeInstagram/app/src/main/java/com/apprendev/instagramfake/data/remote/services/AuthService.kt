package com.apprendev.instagramfake.data.remote.services

import com.apprendev.instagramfake.data.remote.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface AuthService {

    @GET("user?email=Test@gmail.com&password=Test12345")
    fun goToLogin(): Call<LoginResponse>

}
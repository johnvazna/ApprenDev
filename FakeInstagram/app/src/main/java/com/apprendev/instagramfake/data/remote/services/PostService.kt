package com.apprendev.instagramfake.data.remote.services

import com.apprendev.instagramfake.data.remote.responses.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPosts(): Response<ArrayList<PostResponse>>
}
package com.apprendev.instagramfake.data.remote

import com.apprendev.instagramfake.data.remote.model.LoginModel
import com.apprendev.instagramfake.data.remote.responses.ExploreResponse
import com.apprendev.instagramfake.data.remote.responses.LoginResponse
import com.apprendev.instagramfake.data.remote.responses.PostResponse
import com.apprendev.instagramfake.data.remote.services.AuthService
import com.apprendev.instagramfake.data.remote.services.ExplorerService
import com.apprendev.instagramfake.data.remote.services.PostService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private lateinit var postService: PostService
    private lateinit var authService: AuthService
    private lateinit var exploreService: ExplorerService

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://5076996b-691a-44d8-acec-6d375ae7891a.mock.pstmn.io/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()


    /** Post */

    suspend fun getPosts(): Response<ArrayList<PostResponse>> {
        postService = retrofit.create(PostService::class.java)
        return postService.getPosts()
    }

    /** Auth */

    fun goToLogin(login: LoginModel): Call<LoginResponse> {
        authService = retrofit.create(AuthService::class.java)
        return authService.goToLogin()
    }

    /** Explorer */

    suspend fun getExploreData(): Response<ArrayList<ExploreResponse>> {
        exploreService = retrofit.create(ExplorerService::class.java)
        return exploreService.getExplorer()
    }

}
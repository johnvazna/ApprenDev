package com.apprendev.instagramfake.data.remote.services

import com.apprendev.instagramfake.data.remote.responses.ExploreResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExplorerService {

    @GET("explorer")
    suspend fun getExplorer(): Response<ArrayList<ExploreResponse>>

}
package com.apprendev.instagramfake.ui.home

import android.content.Context
import com.apprendev.instagramfake.data.local.LocalDatabase
import com.apprendev.instagramfake.data.local.entities.PostEntity
import com.apprendev.instagramfake.data.remote.RetrofitBuilder
import com.apprendev.instagramfake.utils.Network
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomePresenter(private val context: Context, private val view: HomeContract.View) :
    HomeContract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private lateinit var retrofit: RetrofitBuilder
    private var database: LocalDatabase = LocalDatabase.invoke(context)

    override fun getPosts() {
        if (Network.isNetworkAvailable(context)) {
            launch {
                retrofit = RetrofitBuilder()
                val response = retrofit.getPosts()

                if (response.isSuccessful) {
                    response.body()?.forEach { post ->

                        database.postDao().insert(
                            PostEntity(
                                post.id, post.title, post.description, post.image
                            )
                        )
                    }

                    withContext(Dispatchers.Main) {
                        view.setPosts(database.postDao().getPosts() as ArrayList)
                    }

                } else {
                    view.onError(response.errorBody().toString())
                }
            }
        } else {
            view.onError("Internet not detected")
            view.setPosts(database.postDao().getPosts() as ArrayList)
        }

    }

    override fun onCancel() {
        job.cancel()
    }

}
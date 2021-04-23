package com.apprendev.instagramfake.ui.explorer

import android.content.Context
import com.apprendev.instagramfake.data.local.LocalDatabase
import com.apprendev.instagramfake.data.local.entities.ExploreEntity
import com.apprendev.instagramfake.data.remote.RetrofitBuilder
import com.apprendev.instagramfake.utils.Network
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ExplorePresenter(private val context: Context, private val view: ExploreContract.View) :
    ExploreContract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO

    private var database: LocalDatabase? = null

    override fun getExploreData() {
        if (Network.isNetworkAvailable(context)) {

            launch {
                val response = RetrofitBuilder().getExploreData()
                if (response.isSuccessful) {
                    database = LocalDatabase.invoke(context)
                    response.body()?.forEach { item ->
                        database!!.exploreDao().insert(ExploreEntity(item.id, item.image))
                    }

                    val data = database!!.exploreDao().getExploreData()

                    withContext(Dispatchers.Main) {
                        view.setExploreData(data as ArrayList)
                    }

                } else {
                    view.onError(response.errorBody().toString())
                }
            }
        } else {
            view.onError("Sorry doesn't exist internet connection.")
            view.setExploreData(
                LocalDatabase.invoke(context).exploreDao().getExploreData() as ArrayList
            )
        }
    }

    override fun onCancel() {
        job.cancel()
    }

}
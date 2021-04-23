package com.apprendev.instagramfake.ui.home

import com.apprendev.instagramfake.data.local.entities.PostEntity
import com.apprendev.instagramfake.ui.bases.BasePresenter
import com.apprendev.instagramfake.ui.bases.BaseView

interface HomeContract {

    interface View : BaseView {
        fun setPosts(post: ArrayList<PostEntity>)
    }

    interface Presenter: BasePresenter {
        fun getPosts()
    }

}
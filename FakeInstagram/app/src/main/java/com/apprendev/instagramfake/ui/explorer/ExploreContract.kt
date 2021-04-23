package com.apprendev.instagramfake.ui.explorer

import com.apprendev.instagramfake.data.local.entities.ExploreEntity
import com.apprendev.instagramfake.ui.bases.BasePresenter
import com.apprendev.instagramfake.ui.bases.BaseView

interface ExploreContract {

    interface Presenter: BasePresenter {
        fun getExploreData()
    }

    interface View: BaseView {
        fun setExploreData(data: ArrayList<ExploreEntity>)
    }

}
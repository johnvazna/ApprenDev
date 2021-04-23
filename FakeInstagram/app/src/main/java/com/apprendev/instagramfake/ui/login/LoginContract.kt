package com.apprendev.instagramfake.ui.login

import com.apprendev.instagramfake.ui.bases.BaseView

interface LoginContract {

    interface View: BaseView {
        fun onSuccessLogin()
    }

    interface Presenter {
        fun getSessionUser(): Int
        fun goToLogin(email: String, password: String)
    }

}
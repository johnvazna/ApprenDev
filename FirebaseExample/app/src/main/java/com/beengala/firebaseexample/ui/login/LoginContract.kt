package com.beengala.firebaseexample.ui.login

import com.beengala.firebaseexample.ui.bases.BasePresenter
import com.beengala.firebaseexample.ui.bases.BaseView

interface LoginContract {

    interface Presenter: BasePresenter {
        fun goToLogin(email: String, password: String)
    }

    interface View: BaseView {

    }

}
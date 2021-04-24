package com.beengala.firebaseexample.ui.sign_up

import com.beengala.firebaseexample.ui.bases.BaseView

interface SignUpContract {

    interface Presenter {
        fun setNewUser(email: String, password: String)
    }

    interface View: BaseView
}
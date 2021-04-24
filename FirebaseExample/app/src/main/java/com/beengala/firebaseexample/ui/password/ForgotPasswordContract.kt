package com.beengala.firebaseexample.ui.password

import com.beengala.firebaseexample.ui.bases.BaseView

interface ForgotPasswordContract {
    interface Presenter {
        fun sendResetEmail(email: String)
    }

    interface View: BaseView

}
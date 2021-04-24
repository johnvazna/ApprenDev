package com.beengala.firebaseexample.ui.password

import com.beengala.firebaseexample.utils.ValidEmail
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordPresenter(private val view: ForgotPasswordContract.View) :
    ForgotPasswordContract.Presenter {

    override fun sendResetEmail(email: String) {
        if (!ValidEmail.isEmailValid(email)) {
            view.onError("Please type a correct email")

        } else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view.onSuccess()

                } else {
                    view.onError(task.exception.toString())
                }
            }
        }
    }

}
package com.beengala.firebaseexample.ui.sign_up

import com.beengala.firebaseexample.utils.ValidEmail
import com.google.firebase.auth.FirebaseAuth

class SignUpPresenter(private val view: SignUpContract.View) : SignUpContract.Presenter {

    override fun setNewUser(email: String, password: String) {
        if (!ValidEmail.isEmailValid(email)) {
            view.onError("Please type a correct email")

        } else if (password.isEmpty()) {
            view.onError("Please type a password")

        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { tasks ->
                    if (tasks.isSuccessful) {
                        view.onSuccess()

                    } else {
                        view.onError(tasks.exception.toString())
                    }
                }
        }
    }

}
package com.beengala.firebaseexample.ui.login

import com.beengala.firebaseexample.utils.ValidEmail
import com.google.firebase.auth.FirebaseAuth

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun goToLogin(email: String, password: String) {
        when {
            !ValidEmail.isEmailValid(email) -> {
                view.onError("Please type correct email.")
            }
            password.isEmpty() -> {
                view.onError("Please type any password.")
            }
            else -> {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            view.onSuccess()

                        } else {
                            view.onError(task.exception.toString())
                        }
                    }
            }
        }


    }

}
package com.beengala.firebaseexample.ui.bases

interface BaseView {
    fun onSuccess()
    fun onError(msg: String)
}
package com.beengala.firebaseexample.utils

import android.text.TextUtils
import android.util.Patterns

object ValidEmail {
    fun isEmailValid(email: String): Boolean = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
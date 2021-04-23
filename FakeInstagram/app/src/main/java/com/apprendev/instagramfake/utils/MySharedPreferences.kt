package com.apprendev.instagramfake.utils

import android.content.Context

object MySharedPreferences {

    /** Save user id session */

    fun setUserId(id: Int , context: Context) {
        val sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit().putInt("id", id)
        editor.apply()
    }

    /** Retrieve user id session */

    fun getUserId(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("id", 0)
    }

}
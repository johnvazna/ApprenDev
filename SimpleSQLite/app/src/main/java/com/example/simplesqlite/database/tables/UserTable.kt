package com.example.simplesqlite.database.tables

import android.content.ContentValues
import android.database.Cursor
import com.example.simplesqlite.database.models.User

class UserTable {

    companion object {
        const val TABLE_NAME = "user"

        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_USER_ID = "userId"
        const val COLUMN_PASSWORD = "password"

        fun getColumnsName(): Array<String> {
            return arrayOf(
                COLUMN_ID,
                COLUMN_USER_ID,
                COLUMN_NAME,
                COLUMN_EMAIL,
                COLUMN_PASSWORD
            )
        }

        fun createContentValues(user: User?): ContentValues {
            val values = ContentValues()
            values.put(COLUMN_ID, user!!.id)
            values.put(COLUMN_USER_ID, user.userId)
            values.put(COLUMN_NAME, user.name)
            values.put(COLUMN_EMAIL, user.email)
            values.put(COLUMN_PASSWORD, user.password)
            return values
        }

        fun getUserFromCursor(cursor: Cursor): User? {
            return User(
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USER_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD))
            )
        }

    }

}
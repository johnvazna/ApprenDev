package com.example.simplesqlite.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.simplesqlite.database.models.Note
import com.example.simplesqlite.database.models.User
import com.example.simplesqlite.database.tables.NoteTable
import com.example.simplesqlite.database.tables.UserTable
import java.sql.SQLException

@Suppress("PrivatePropertyName")
class DatabaseHelper(private val context: Context): SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    private lateinit var database: SQLiteDatabase

    private val TYPE_TEXT = " TEXT "
    private val TYPE_INTEGER = " INTEGER "

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "databaseExample.db"
    }

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(TABLE_USER)
        database?.execSQL(TABLE_NOTES)
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        database?.execSQL("drop table if exists " + UserTable.TABLE_NAME)
        database?.execSQL("drop table if exists " + NoteTable.TABLE_NAME)
        onCreate(database)
    }

    private val TABLE_USER = "CREATE TABLE " + UserTable.TABLE_NAME + " (" +
            UserTable.COLUMN_ID + " $TYPE_INTEGER PRIMARY KEY AUTOINCREMENT," +
            UserTable.COLUMN_USER_ID + TYPE_TEXT + ", " + UserTable.TABLE_NAME + TYPE_TEXT + ", "  +
            UserTable.COLUMN_EMAIL + TYPE_TEXT + ", " + UserTable.COLUMN_PASSWORD + TYPE_TEXT + " )"

    private val TABLE_NOTES = "CREATE TABLE " + NoteTable.TABLE_NAME + " (" +
            NoteTable.COLUMN_ID + " $TYPE_INTEGER PRIMARY KEY AUTOINCREMENT," +
            NoteTable.COLUMN_TITLE + TYPE_TEXT + ", " + NoteTable.COLUMN_DESCRIPTION + TYPE_TEXT + ", " +
            NoteTable.COLUMN_DATE + TYPE_TEXT + " )"

    //User

    @Synchronized
    fun createUser(user: User): User? {
        open()

        var newUser: User? = null
        val id = executedCreated(UserTable.TABLE_NAME, UserTable.createContentValues(user)).toInt()

        if (id > 0) {
             newUser = getUser(id)
        }

        close()
        return newUser
    }

    @Synchronized
    fun updateUser(user: User): User? {
        open()

        val response: Boolean
        var updateUser: User? = null

        try {
            if (user.id != 0) {
                response = executionUpdate(UserTable.TABLE_NAME, UserTable.createContentValues(user), "id = ?", arrayOf(user.id.toString()))
                if (response) {
                    updateUser = getUser(user.id)
                }
            }

        } catch (e: SQLException) {
            e.localizedMessage
        }

        close()
        return updateUser
    }

    @Synchronized
    fun deleteUser(user: User): Boolean {
        open()

        var response = false

        try {
            response = executionDelete(UserTable.TABLE_NAME, "id = ?", arrayOf(user.id.toString()))

        } catch (e: SQLException) {
            e.localizedMessage
        }

        close()
        return response
    }

    @Synchronized
    fun getUser(id: Int): User? {
        open()

        var user: User? = null
        val cursor: Cursor? = executionSelect(UserTable.TABLE_NAME, UserTable.getColumnsName(), "id = ?", arrayOf(id.toString()), null)

        if (cursor != null) {
            if (cursor.count == 1) {
                cursor.moveToFirst()
                user = UserTable.getUserFromCursor(cursor)
            }
            cursor.close()
        }

        close()
        return user
    }

    //Note

    @Synchronized
    fun createNote(note: Note): Note? {
        open()

        var newNote: Note? = null
        val id = executedCreated(NoteTable.TABLE_NAME, NoteTable.createContentValues(note)).toInt()

        if (id > 0) {
            newNote = getNote(id)
        }

        close()
        return newNote
    }

    @Synchronized
    fun updateNote(note: Note): Note? {
        open()

        val response: Boolean
        var updateNote: Note? = null

        try {
            if (note.id != 0) {
                response = executionUpdate(NoteTable.TABLE_NAME, NoteTable.createContentValues(note), "id = ?", arrayOf(note.id.toString()))
                if (response) {
                    updateNote = getNote(note.id)
                }
            }

        } catch (e: SQLException) {
            e.localizedMessage
        }

        close()
        return updateNote
    }

    @Synchronized
    fun deleteNote(note: Note): Boolean {
        open()

        var response = false

        try {
            response = executionDelete(NoteTable.TABLE_NAME, "id = ?", arrayOf(note.id.toString()))

        } catch (e: SQLException) {
            e.localizedMessage
        }

        close()
        return response
    }

    @Synchronized
    fun getNote(id: Int): Note? {
        open()

        var note: Note? = null
        val cursor: Cursor? = executionSelect(NoteTable.TABLE_NAME, NoteTable.getColumnsName(), "id = ?", arrayOf(id.toString()), null)

        if (cursor != null) {
            if (cursor.count == 1) {
                cursor.moveToFirst()
                note = NoteTable.getNoteFromCursor(cursor)
            }
            cursor.close()
        }

        close()
        return note
    }

    //General

    @Throws(SQLException::class)
    private fun open() {
        database = writableDatabase
    }

    @Throws(SQLException::class)
    private fun executionSelect(tableName: String, columns: Array<String>, whereClause: String, whereArgs: Array<String>, orderBy: String?): Cursor {
        if (!database.isOpen) {
            database = writableDatabase
        }
        return database.query(tableName, columns, whereClause, whereArgs, null, null, orderBy)
    }

    @Throws(SQLException::class)
    private fun executionDelete(tableName: String, whereClause: String, whereArgs: Array<String>): Boolean {
        if (!database.isOpen) {
            database = writableDatabase
        }
        val numRowsAffected = database.delete(tableName, whereClause, whereArgs)
        return (numRowsAffected > 0)
    }

    @Throws(SQLException::class)
    private fun executionUpdate(tableName: String, contentValues: ContentValues, whereClause: String, whereArgs: Array<String>): Boolean {
        if (!database.isOpen) {
            database = writableDatabase
        }
        val numRowsAffected = database.update(tableName, contentValues, whereClause, whereArgs)
        return (numRowsAffected > 0)
    }

    @Throws(SQLException::class)
    private fun executedCreated(tableName: String, contentValues: ContentValues): Long {
        if (!database.isOpen) {
            database = writableDatabase
        }
        return database.insert(tableName, null, contentValues)
    }

}
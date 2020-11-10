package com.example.simplesqlite.database.tables

import android.content.ContentValues
import android.database.Cursor
import com.example.simplesqlite.database.models.Note

class NoteTable {

    companion object {
        const val TABLE_NAME = "notes"

        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_DATE = "date"

        fun getColumnsName(): Array<String> {
            return arrayOf(
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_DESCRIPTION,
                COLUMN_DATE
            )
        }

        fun createContentValues(note: Note): ContentValues {
            val values = ContentValues()
            values.put(COLUMN_ID, note.id)
            values.put(COLUMN_TITLE, note.title)
            values.put(COLUMN_DESCRIPTION, note.description)
            values.put(COLUMN_DATE, note.date)
            return values
        }

        fun getNoteFromCursor(cursor: Cursor): Note? {
            return Note(
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))
            )
        }

    }

}
package com.example.simplesqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplesqlite.note.NoteFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add fragment into container

        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.container, NoteFragment())
        transition.addToBackStack(null)
        transition.commit()

    }

}
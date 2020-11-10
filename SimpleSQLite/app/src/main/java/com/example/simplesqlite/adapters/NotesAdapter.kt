package com.example.simplesqlite.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesqlite.R
import com.example.simplesqlite.database.models.Note

class NotesAdapters(private val notes: ArrayList<Note>): RecyclerView.Adapter<NoteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        //Create and connected the view
        return NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        //Connect the view with the components
        val note = notes[position]
        holder.tvTitle.text = note.title
        holder.tvDescription.text = note.description
    }

    override fun getItemCount(): Int {
        //Returned all the size objects
        return notes.size
    }

}
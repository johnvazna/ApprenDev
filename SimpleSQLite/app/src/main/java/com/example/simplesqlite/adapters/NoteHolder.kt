package com.example.simplesqlite.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesqlite.R

class NoteHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvTitle = view.findViewById(R.id.tvTitle) as TextView
    val tvDescription = view.findViewById(R.id.tvDescription) as TextView
}
package com.example.simplelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplelist.R
import com.example.simplelist.adapter.holder.ContactHolder
import com.example.simplelist.adapter.listeners.ContactListener
import com.example.simplelist.model.Contact

class ContactAdapter(private val contacts: ArrayList<Contact>, private val listener: ContactListener): RecyclerView.Adapter<ContactHolder>() {

    //Connection the adapter with the respective layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false))
    }

    //Connection the data with the components
    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contacts[position]
        holder.tvName.text = contact.name
        holder.tvPhone.text = contact.phone.toString()
        holder.imgProfile.setImageResource(contact.image)

        //Event to view click
        holder.itemView.setOnClickListener {
            listener.clickContact(contact)
        }

    }

    //Return all items created
    override fun getItemCount(): Int {
        return contacts.size
    }

}
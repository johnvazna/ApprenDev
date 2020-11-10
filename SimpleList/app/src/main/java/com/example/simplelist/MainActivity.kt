package com.example.simplelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplelist.adapter.ContactAdapter
import com.example.simplelist.adapter.listeners.ContactListener
import com.example.simplelist.description.DescriptionActivity
import com.example.simplelist.model.Contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creation data contacts
        val contacts = ArrayList<Contact>()
        contacts.add(Contact("Contact 1",1234567890, "This is a new person", R.drawable.profile_one))
        contacts.add(Contact("Contact 2", 1234567890, "This is an another new person", R.drawable.profile_two))
        contacts.add(Contact("Contact 3", 1234567890, "This is an another new person but with different name", R.drawable.profile_three))

        //Add divider item view
        val dividerItem = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val adapter = ContactAdapter(contacts, this)
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.setHasFixedSize(true)
        rvContacts.addItemDecoration(dividerItem)
        rvContacts.adapter = adapter

    }

    //Event inherited from the listener
    override fun clickContact(contact: Contact) {
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtra("contact", contact)
        startActivity(intent)
    }

}
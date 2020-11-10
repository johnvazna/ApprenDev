package com.example.simplelist.description

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.simplelist.R
import com.example.simplelist.model.Contact

class DescriptionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        //Capture event sent object
        val contact = intent.getSerializableExtra("contact") as Contact

        Log.e("TAG", "Name: ${contact.name}")
        Log.e("TAG", "Phone: ${contact.phone}")
        Log.e("TAG", "Description: ${contact.description}")

    }

    override fun onBackPressed() {
        super.onBackPressed()
        //Event to back button
        finish()
    }

}
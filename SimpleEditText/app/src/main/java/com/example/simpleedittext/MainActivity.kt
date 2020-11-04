package com.example.simpleedittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listeners are ways of listening to the events of each component, which perform
        // and expected action.

        editTextPhone.addTextChangedListener(listener())
        editTextNumber.addTextChangedListener(listener())
        editTextTextPassword.addTextChangedListener(listener())
        editTextTextPersonName.addTextChangedListener(listener())

    }

    //You can control the events of a text box to perform an action when writing a Text

    private fun listener() = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //What will happen before I start writing
        }

        override fun onTextChanged(message: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //What will happen while you write
            tvMessage.text = message
        }

        override fun afterTextChanged(p0: Editable?) {
            //What will happen after to finish writing
        }

    }

}
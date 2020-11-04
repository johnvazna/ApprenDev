package com.example.simplebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            Remember that each component has its respective listener,
            we can activate functions within our listeners, such as activating buttons,
            changing the text, changing colors.. etc.
         */

        btnOne.setOnClickListener {
            tvMessage.text = getString(R.string.first_message)
            btnTwo.isEnabled = true
            btnTwo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorButton))
        }

        btnTwo.setOnLongClickListener {
            tvMessage.text = getString(R.string.second_message)
            btnTwo.isEnabled = false
            btnTwo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDisable))
            true
        }

    }
}
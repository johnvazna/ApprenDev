package com.example.simplefunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            In our listener we send to invoke the name our function
         */

        btnEvent.setOnClickListener {
            showMessageToUser()
        }

    }

    /*
        We use the reserved word fun to create a function in our code,
        followed by the name of the function (Let's try to keep name clear
        and direct to what it does) which inside its body to perform to complete the operation.

        We add the word "Private" to make your function private so that we can only
        access it within our code.

     */

    private fun showMessageToUser() {
        txvMessage.text = getString(R.string.message_button)
    }

}
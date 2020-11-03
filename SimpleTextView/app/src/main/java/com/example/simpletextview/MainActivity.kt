package com.example.simpletextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //You can change the text with the respective ID
        tvTest.text = "This not change"

        //Change the respective size
        tvTest.textSize = 12F

        //Or maybe try to different color
        tvTest.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))

    }
}
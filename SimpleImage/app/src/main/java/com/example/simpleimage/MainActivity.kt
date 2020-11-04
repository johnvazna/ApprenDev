package com.example.simpleimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            Images are the most popular component when making an application.
            For this reason, we fin a series of option in which we can add different images in our project

            In the current example you can fin test images. that are part of the Android Studio Environment.

            To add an image directly to your project, remember to add it to your Drawable folder
            (Whether it's a PNG or Vector)

            In XML/Design mode:

            android:src = "drawable/nameOfImage"

            or you can add it dynamically through code:

            image_view_resource.setImageResource(R.drawable.nameOfImage)

         */

    }
}
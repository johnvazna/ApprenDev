package com.example.simplesqlite.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplesqlite.R
import com.example.simplesqlite.database.DatabaseHelper
import com.example.simplesqlite.database.models.User
import com.example.simplesqlite.login.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.*

class SignUpActivity: AppCompatActivity(), View.OnClickListener {

    var database: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        database = DatabaseHelper(this)

        tvLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvLogin -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.btnRegister -> {
                val etName = etName.text.toString()
                val etEmail = etEmail.text.toString()
                val etPassword = etPassword.text.toString()

                when {
                    etName.isEmpty() -> {
                        Toast.makeText(this, "Please, type an name", Toast.LENGTH_SHORT).show()
                    }
                    etEmail.isEmpty() -> {
                        Toast.makeText(this, "Please, type an email", Toast.LENGTH_SHORT).show()
                    }
                    etPassword.isEmpty() -> {
                        Toast.makeText(this, "Please, type an password", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        val id = UUID.randomUUID().toString()
                        val user = database?.createUser(User(etName))
                    }
                }

            }
        }
    }

}
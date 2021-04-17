package com.example.simplesqlite.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplesqlite.MainActivity
import com.example.simplesqlite.R
import com.example.simplesqlite.database.DatabaseHelper
import com.example.simplesqlite.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(), View.OnClickListener {

    var database: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        database = DatabaseHelper(this)

        tvSignUp.setOnClickListener(this)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnLogin -> {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                when {
                    email.isEmpty() -> {
                        Toast.makeText(this, "Please, type an email", Toast.LENGTH_SHORT).show()
                    }
                    password.isEmpty() -> {
                        Toast.makeText(this, "Please, type an password", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

            }
            R.id.tvSignUp -> {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}
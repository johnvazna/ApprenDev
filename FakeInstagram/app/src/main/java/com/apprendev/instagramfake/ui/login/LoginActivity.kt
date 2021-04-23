package com.apprendev.instagramfake.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, this)

        btnLogin.setOnClickListener {
            presenter!!.goToLogin("Test@gmail.com", "Test12345")
        }
    }

    override fun onStart() {
        super.onStart()
        if (presenter!!.getSessionUser() != 0) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onSuccessLogin() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
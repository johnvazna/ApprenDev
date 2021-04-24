package com.beengala.firebaseexample.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beengala.firebaseexample.MainActivity
import com.beengala.firebaseexample.R
import com.beengala.firebaseexample.ui.password.ForgotPasswordActivity
import com.beengala.firebaseexample.ui.sign_up.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity(), LoginContract.View, View.OnClickListener {

    private var auth: FirebaseAuth? = null
    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        presenter = LoginPresenter(this)
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        if (auth?.currentUser != null) {
            onSuccess()
        }
    }

    override fun onSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> presenter?.goToLogin(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
            R.id.tvSignUp -> startActivity(Intent(this, SignUpActivity::class.java))
            R.id.tvForgotPassword -> startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

}
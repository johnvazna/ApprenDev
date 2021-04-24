package com.beengala.firebaseexample.ui.password

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beengala.firebaseexample.R
import kotlinx.android.synthetic.main.forgot_password_activity.*

class ForgotPasswordActivity: AppCompatActivity(), ForgotPasswordContract.View {

    private var presenter: ForgotPasswordPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password_activity)

        presenter = ForgotPasswordPresenter(this)

        btnSend.setOnClickListener {
            presenter!!.sendResetEmail(etEmail.text.toString())
        }
    }

    override fun onSuccess() {
        finish()
        Toast.makeText(this, "Verify your email.", Toast.LENGTH_LONG).show()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
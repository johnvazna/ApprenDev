package com.beengala.firebaseexample.ui.sign_up

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beengala.firebaseexample.MainActivity
import com.beengala.firebaseexample.R
import com.beengala.firebaseexample.ui.login.LoginActivity
import kotlinx.android.synthetic.main.sign_up_activty.*

class SignUpActivity : AppCompatActivity(), SignUpContract.View, View.OnClickListener {

    private var presenter: SignUpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activty)

        presenter = SignUpPresenter(this)

        btnFinish.setOnClickListener(this)
        tvLogin.setOnClickListener(this)
    }

    override fun onSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvLogin -> startActivity(Intent(this, LoginActivity::class.java))
            R.id.btnFinish -> presenter?.setNewUser(etEmail.text.toString(), etPassword.text.toString())
        }
    }

}
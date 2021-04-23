package com.apprendev.instagramfake.ui.login

import android.content.Context
import com.apprendev.instagramfake.data.local.LocalDatabase
import com.apprendev.instagramfake.data.local.entities.UserEntity
import com.apprendev.instagramfake.data.remote.RetrofitBuilder
import com.apprendev.instagramfake.data.remote.model.LoginModel
import com.apprendev.instagramfake.data.remote.responses.LoginResponse
import com.apprendev.instagramfake.utils.DialogProgress
import com.apprendev.instagramfake.utils.MySharedPreferences
import com.apprendev.instagramfake.utils.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val context: Context, private val view: LoginContract.View) :
    LoginContract.Presenter {

    private var database: LocalDatabase? = null
    private var retrofit: RetrofitBuilder? = null

    override fun getSessionUser(): Int {
        return MySharedPreferences.getUserId(context)
    }

    override fun goToLogin(email: String, password: String) {
        if (Network.isNetworkAvailable(context)) {
            when {
                email.isEmpty() -> {
                    view.onError("Please type any email.")
                }
                password.isEmpty() -> {
                    view.onError("Please type any password")
                }
                else -> {
                    retrofit = RetrofitBuilder()
                    DialogProgress.showDialog(context, "Wait a second..")
                    retrofit!!.goToLogin(LoginModel(email, password))
                        .enqueue(object : Callback<LoginResponse> {
                            override fun onResponse(
                                call: Call<LoginResponse>,
                                response: Response<LoginResponse>
                            ) {
                                if (response.code() == 200) {
                                    database = LocalDatabase.invoke(context)
                                    database!!.userDao().createUser(
                                        UserEntity(
                                            response.body()!!.id,
                                            response.body()!!.email,
                                            response.body()!!.name,
                                            response.body()!!.last_name
                                        )
                                    )

                                    MySharedPreferences.setUserId(response.body()!!.id, context)
                                    view.onSuccessLogin()
                                    DialogProgress.hideDialog()

                                } else if (response.code() == 404) {
                                    view.onError("Sorry the user doesn't exist")
                                }
                            }

                            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                view.onError(t.message.toString())
                            }

                        })
                }
            }

        } else {
            view.onError("Error, not internet detected.")
        }
    }

}
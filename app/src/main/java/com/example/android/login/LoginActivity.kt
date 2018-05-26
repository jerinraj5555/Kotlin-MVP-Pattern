package com.example.android.login

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.android.R


class LoginActivity : Activity(), LoginViewInterface {

    @BindView(R.id.progress)
    lateinit var progressBar: ProgressBar
    @BindView(R.id.email)
    lateinit var tvEmail: AutoCompleteTextView
    @BindView(R.id.password)
    lateinit var tvPassword: EditText
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        initPresenter()
    }

    private fun initPresenter() {
        loginPresenter = LoginPresenter()
        loginPresenter.onAttach(this,LoginInteractor())
    }

    @OnClick(R.id.btnSignIn)
   internal fun onClick() {
        loginPresenter.validateUserCredentails(tvEmail.text.toString(), tvPassword.text.toString())
    }

    override fun onLoginFailure() {
        tvEmail.setError(getString(R.string.login_failure))
    }

    override fun setUserNameError() {
        tvEmail.setError(getString(R.string.error_invalid_email))
    }

    override fun setPasswordError() {
    tvPassword.setError(getString(R.string.error_invalid_password))
    }

    override fun navigateToHomeScreen() {
        Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.onDestroy()
    }
}
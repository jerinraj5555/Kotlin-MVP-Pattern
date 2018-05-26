package com.example.android.login

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.android.R


public class LoginActivity : AppCompatActivity(), LoginViewInterface {


    lateinit var loginPresenter: LoginPresenter


    @BindView(R.id.progress)
    var progressBar: ProgressBar? = null
    @BindView(R.id.email)
    var tvEmail: AutoCompleteTextView? = null
    @BindView(R.id.password)
    var tvPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this);
        initPresenter();
    }

    private fun initPresenter() {
        loginPresenter = LoginPresenter(this, LoginInteractor())
    }

    @OnClick(R.id.btnSignIn)
    fun onClick() {
        showProgress()
        loginPresenter.validateUserCredentails(tvEmail?.text.toString(), tvPassword?.text.toString())
    }

    override fun onLoginFailure() {
        tvEmail?.setError(getString(R.string.login_failure))
    }

    override fun setUserNameError() {
        tvEmail?.setError(getString(R.string.error_invalid_email))
    }

    override fun setPasswordError() {
    tvPassword?.setError(getString(R.string.error_invalid_password))
    }

    override fun navigateToHomeScreen() {
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun dismissProgress() {
        progressBar?.visibility = View.GONE
    }


}
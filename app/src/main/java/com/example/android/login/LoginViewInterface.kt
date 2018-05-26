package com.example.android.login

public interface LoginViewInterface {

    fun showProgress()
    fun dismissProgress()
    fun setUserNameError()
    fun setPasswordError()
    fun navigateToHomeScreen()
    fun onLoginFailure()
}
package com.example.android.login

interface LoginInteractorInterface {
    public interface OnLoginFinishInterface{
        fun  onLoginSuccess()
        fun onLoginFailure()
        fun onPasswordError()
        fun onUserNameError()
    }

    fun validateUserName(name: String, passwrd : String,loginFinish : OnLoginFinishInterface)
}
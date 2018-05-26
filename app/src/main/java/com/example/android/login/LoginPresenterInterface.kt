package com.example.android.login

interface LoginPresenterInterface {
    fun validateUserCredentails(uname : String,pwd : String)
    fun onDestroy()
}
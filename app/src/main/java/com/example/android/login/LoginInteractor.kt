package com.example.android.login

import android.text.TextUtils

class LoginInteractor : LoginInteractorInterface {
    override fun validateUserName(name: String, passwrd: String,
                                  loginFinish: LoginInteractorInterface.OnLoginFinishInterface) {
        if(TextUtils.isEmpty(name)){
            loginFinish.onUserNameError()
            return
        }
        else if(TextUtils.isEmpty(passwrd)){
            loginFinish.onPasswordError()
            return
        }

    }
}
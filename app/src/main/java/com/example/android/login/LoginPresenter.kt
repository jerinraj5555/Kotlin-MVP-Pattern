package com.example.android.login

class LoginPresenter (): LoginPresenterInterface,
        LoginInteractorInterface.OnLoginFinishInterface {

     var   logInViewInterface: LoginViewInterface ?= null
     var   logInInteractor: LoginInteractorInterface?= null

    fun onAttach( logInViewInterface: LoginViewInterface , logInInteractor:
    LoginInteractorInterface){
        this.logInInteractor = logInInteractor
        this.logInViewInterface = logInViewInterface
    }


    override fun onLoginSuccess() {

    }
    override fun onLoginFailure() {
        logInViewInterface?.setPasswordError()

    }

    override fun onPasswordError() {
        logInViewInterface?.setPasswordError()
    }

    override fun onUserNameError() {
        logInViewInterface?.setUserNameError()

    }
    override fun validateUserCredentails(uname: String, pwd: String) {
        logInInteractor?.validateUserName(uname,toString(),this)
    }

    override fun onDestroy() {
        this.logInInteractor = null
        this.logInViewInterface = null
    }

}
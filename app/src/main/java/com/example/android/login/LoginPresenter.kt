package com.example.android.login

class LoginPresenter (val logInViewInterface: LoginViewInterface, val logInInteractor:
LoginInteractorInterface): LoginPresenterInterface,
        LoginInteractorInterface.OnLoginFinishInterface {

    override fun onLoginSuccess() {

    }

    override fun onLoginFailure() {
        logInViewInterface.setPasswordError()

    }

    override fun onPasswordError() {
        logInViewInterface.setPasswordError()
    }

    override fun onUserNameError() {
        logInViewInterface.setUserNameError()

    }
    override fun validateUserCredentails(uname: String, pwd: String) {
        logInInteractor.validateUserName(uname,toString(),this)
    }

    override fun onDestroy() {
    }

}
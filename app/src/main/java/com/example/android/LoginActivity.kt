package com.example.android

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick


public class LoginActivity : AppCompatActivity() {
    @BindView(R.id.title)
    var title: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this);


    }

    @OnClick(R.id.email_sign_in_button)
    fun submit() {
        // TODO submit data to server...
    }


}
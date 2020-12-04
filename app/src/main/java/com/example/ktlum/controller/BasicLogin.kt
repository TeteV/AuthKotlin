package com.example.ktlum.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.ktlum.AuthService.AuthServiceImpl
import com.example.ktlum.R
import com.example.ktlum.model.User

class BasicLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_login)

        // get reference to all views
        var et_email = findViewById(R.id.editTextEmail) as EditText
        var et_password = findViewById(R.id.editTextPass) as EditText
        var btn_submit = findViewById(R.id.LIBtn) as Button


        // set on-click listener
        btn_submit.setOnClickListener {
            val email = et_email.text;
            val password = et_password.text;

            val user = User(email.toString(),password.toString())
            logIn(user)
        }
    }

    private fun logIn(user: User){
        val authServiceImpl = AuthServiceImpl()
        authServiceImpl.logIn(this,user){run{

        }}
    }


    }
package com.example.ktlum.controller

import android.content.Intent
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

            val user = User(0,email.toString(),password.toString(),"","")
            logIn(user)
        }

        listeners()
    }

    private fun logIn(user: User){
        val authServiceImpl = AuthServiceImpl()
        authServiceImpl.logIn(this,user){run{
            
            val intent = Intent(this, SuccessLogin::class.java)
            startActivity(intent)
        }}
    }

    private fun listeners(){
        val plsssBtn = findViewById<Button>(R.id.CrudBtn)
        plsssBtn.setOnClickListener {
            val intent = Intent(this, SuccessLogin::class.java)
            startActivity(intent)
        }
    }



    }
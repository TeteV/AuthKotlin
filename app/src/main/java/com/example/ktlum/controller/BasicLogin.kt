package com.example.ktlum.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ktlum.AuthService.AuthServiceImpl
import com.example.ktlum.R
import com.example.ktlum.model.User
import com.example.ktlum.util.PreferenceHelper
import com.example.ktlum.util.PreferenceHelper.set

class BasicLogin : AppCompatActivity() {
    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_login)

        getDataLogin()
        listeners()
    }

    private fun logIn(context:Context,user:User){
        val authServiceImpl = AuthServiceImpl()
        authServiceImpl.logIn(this,user)
        {
            /*val token : String = this.intent.getStringExtra("api_token").toString()
            val id_us : String = this.intent.getStringExtra("id_user").toString()*/

            run {

                /*Log.v("LoginWapo","ID en lognwapo1: "+id_us)
                createSessionPreference(token,id_us.toInt())*/
                val intent = Intent(context, SuccessLogin::class.java)
                intent.putExtra("api_token", user.api_token)
                intent.putExtra("iduser", user.userId)
                Log.v("VilHolder func", user.api_token)
                context.startActivity(intent)
        }}
    }

    private fun listeners(){
        val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val porahoraBtn = findViewById<Button>(R.id.CrudBtn)
        porahoraBtn.setOnClickListener {
            val intent = Intent(this,SuccessLogin::class.java)
            startActivity(intent)
        }

        val FPBtn = findViewById<TextView>(R.id.textViewFP)
        FPBtn.setOnClickListener {
            val intent = Intent(this, ForgotPwd::class.java)
            startActivity(intent)
        }
    }

    private fun getDataLogin(){
        //Aqui añadir el apitoken
        var et_email = findViewById(R.id.editTextEmail) as EditText
        var et_password = findViewById(R.id.editTextPass) as EditText
        var btn_submit = findViewById(R.id.LIBtn) as Button


        // set on-click listener
        btn_submit.setOnClickListener {
            val email = et_email.text;
            val password = et_password.text;

            val user = User(0,email.toString(),password.toString(),"","","")
            logIn(this,user)
        }
    }

    private fun createSessionPreference(token: String, userId: Int){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["token"] = token
        preferences["userId"] = userId
    }



    }
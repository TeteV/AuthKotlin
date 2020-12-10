package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.ktlum.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listeners();
    }

    private fun listeners(){
        val loginBtn = findViewById<Button>(R.id.LIBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this,BasicLogin::class.java)
            startActivity(intent)
        }

        val signupBtn = findViewById<Button>(R.id.SIBtn)
        signupBtn.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        val porahoraBtn = findViewById<Button>(R.id.CrudBtn)
        porahoraBtn.setOnClickListener {
            val intent = Intent(this,SuccessLogin::class.java)
            startActivity(intent)
        }
    }
}
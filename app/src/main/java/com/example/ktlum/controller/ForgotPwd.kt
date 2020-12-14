package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ktlum.R

class ForgotPwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pwd)

        listeners()
    }

    private fun listeners(){

        val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val submBtn = findViewById<Button>(R.id.submBtn)
        submBtn.setOnClickListener {
            val email: String = findViewById<TextView>(R.id.editTextEmail).text.toString()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Send Email")
            builder.setMessage("Send email to: "+email + " ?")
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                        applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                try {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                catch (e: Exception) {
                    Log.v("Edit", "Error en el catch")
                }
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(
                        applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()
        }
    }
}
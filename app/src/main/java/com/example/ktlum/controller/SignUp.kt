package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.ktlum.AuthService.AuthServiceImpl
import com.example.ktlum.R
import com.example.ktlum.model.User

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        listeners()
    }

private fun listeners(){
    val signupBtn = findViewById<Button>(R.id.SignUpBtn)
    signupBtn.setOnClickListener {
        val id = this.intent.getIntExtra("id", 0)
        val dni: String = findViewById<TextView>(R.id.editTextDni).text.toString()
        val name: String = findViewById<TextView>(R.id.editTextName).text.toString()
        val email: String = findViewById<TextView>(R.id.editTextEmail).text.toString()
        val pwd: String = findViewById<TextView>(R.id.editTextPwd).text.toString()

        val user = User(id,email,pwd,name,dni)
        Log.v("Create", user.toString())
        createUser(user);
    }

    val backBtn = findViewById<Button>(R.id.BackBtn)
    backBtn.setOnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
     private fun createUser(user: User){
         val authServiceImpl = AuthServiceImpl()
         authServiceImpl.createUser(this, user) { ->
             run {
                 val intent = Intent(this, BasicLogin::class.java)
                  startActivity(intent)
             }
         }
     }

}
package com.example.ktlum.controller

import android.accounts.AccountManager
import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ktlum.R
import com.example.ktlum.RoomService.RoomServiceImpl

class SuccessLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_login)


        val email : String? = this.intent.getStringExtra("email")
        val token : String? = this.intent.getStringExtra("token")

        listeners()
        Log.v("succ","email: "+ email)
        Log.v("succ","token: "+ token)
    }

    private fun listeners(){
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        searchBtn.setOnClickListener {
            val intent = Intent(this,RoomList::class.java)
            startActivity(intent)
        }

        val userBtn = findViewById<Button>(R.id.userBtn)
        userBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
        }
       /* val searchBtn = findViewById<Button>(R.id.searchBtn)
        searchBtn.setOnClickListener {
            val numPpl: Int = findViewById(R.id.editTextNumber)
            val roomServiceImpl = RoomServiceImpl()
            roomServiceImpl.getByPpl(this, numPpl) { response ->
                run {
                    numPpl.setText(response?.num_ppl ?: "")
                }
            }
            val intent = Intent(this,RoomList::class.java)
            startActivity(intent)
        }
*/

    }

}

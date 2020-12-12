package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.ktlum.R
import com.example.ktlum.RoomService.RoomServiceImpl

class RoomDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_details)

        val num:Int = this.intent.getIntExtra("num",0)

        listeners()
        getByNum(num)
    }

    private fun listeners(){ val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, SuccessLogin::class.java)
            startActivity(intent)
        }

        val userBtn = findViewById<Button>(R.id.userBtn)
        userBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getByNum(num: Int) {

        val roomServiceImpl = RoomServiceImpl()
        roomServiceImpl.getByNum(this, num) { response ->
            run {
                val numDe: TextView = findViewById(R.id.RoomNDetails)
                val size: TextView = findViewById(R.id.RoomSize)
                val nppl: TextView = findViewById(R.id.NPers)
                numDe.setText(response?.num.toString() ?: "")
                size.setText(response?.size.toString() ?: "")
                nppl.setText(response?.num_ppl.toString() ?: "")
            }
        }
    }
}
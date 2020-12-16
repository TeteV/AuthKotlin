package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ktlum.R
import com.example.ktlum.RoomService.RoomServiceImpl

class RoomDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_details)

        /*val id_us : String? = this.intent.getStringExtra("id_user")
        Log.v("roomdetail","id User : "+ id_us)*/

        val num: Int = this.intent.getIntExtra("num", 0)

        listeners()
        getByNum(num)
    }

    /*fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_LONG).show()
    }*/

    private fun listeners() {
        val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, SuccessLogin::class.java)
            /*val id_us : String? = this.intent.getStringExtra("id_user")
            intent.putExtra("id_user", id_us)*/
            startActivity(intent)
        }

        val userBtn = findViewById<Button>(R.id.userBtn)
        userBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            /*val id_us : String? = this.intent.getStringExtra("id_user")
            intent.putExtra("id_user", id_us)*/
            startActivity(intent)
        }

        val bookBtn = findViewById<Button>(R.id.BookBtn)
        bookBtn.setOnClickListener {
            val num: String = findViewById<TextView>(R.id.RoomNDetails).text.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Book")
            builder.setMessage("Want to book Room: "+num+" ?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                try {
                    //updateUser(user)
                } catch (e: Exception) {
                    Log.v("GetRoom", "Error en el catch")
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

    private fun getByNum(num: Int) {

        val roomServiceImpl = RoomServiceImpl()
        roomServiceImpl.getByNum(this, num) { response ->
            run {
                Log.v("Getbynum","Aquipaso")
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
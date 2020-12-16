package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.ktlum.R
import com.example.ktlum.util.PreferenceHelper
import com.example.ktlum.util.PreferenceHelper.set

class SuccessLogin : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_login)

        val userId = preferences.getInt("userId", 0)
        val tokenas = preferences.getString("token",null)
        Log.v("succ","id User toint : "+ userId)
        Log.v("succ","Tokenas : "+ tokenas)
//Aqui hay un error que cada vez que vuelvo de una pagina que no sea el LGIN los intent los recibe en null

        val token : String = this.intent.getStringExtra("api_token").toString()
        val id_us : String = this.intent.getStringExtra("id_user").toString()
        Log.v("succ","id_us : "+ id_us)
        Log.v("succ","api_Token : "+ token)


        if (tokenas.toString() == token){
            Log.v("succ","tokens Igualitos")
        }else{
            Log.v("succ","tokens diferentitos, crear sesi ")
            createSessionPreference(token,id_us.toInt())
        }




        listeners()
    }

    private fun listeners(){
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val nppl = findViewById<TextView>(R.id.editTextNumberPpl).text
        searchBtn.setOnClickListener {
            val intent = Intent(this,RoomList::class.java)
            intent.putExtra("num_ppl", nppl )
            startActivity(intent)
        }

        val userBtn = findViewById<Button>(R.id.userBtn)
        userBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            /*val id_us : String? = this.intent.getStringExtra("id_user")
            intent.putExtra("id_user", id_us)*/
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

    }//listeners
    private fun createSessionPreference(token: String, userId: Int){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["token"] = token
        preferences["userId"] = userId
    }



}

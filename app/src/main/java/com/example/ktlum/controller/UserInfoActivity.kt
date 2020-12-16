package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ktlum.AuthService.AuthServiceImpl
import com.example.ktlum.R
import com.example.ktlum.UserService.UserServiceImpl
import com.example.ktlum.model.User
import com.example.ktlum.util.PreferenceHelper
import com.squareup.picasso.Picasso

class UserInfoActivity : AppCompatActivity() {

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val userId = preferences.getInt("userId", 0)

        getById(userId)


        listeners()

    }

    private fun listeners(){
        val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, SuccessLogin::class.java)

            startActivity(intent)
        }

        val logoutBtn = findViewById<Button>(R.id.LogOutBtn)
        logoutBtn.setOnClickListener {
            //logOutUser()
        }

        val updateBtn = findViewById<Button>(R.id.updateBtn)
        updateBtn.setOnClickListener {
            //val id: Int = findViewById<TextView>(R.id.idTxt).text.toString().toInt()
            val dni: String = findViewById<TextView>(R.id.editTextDni).text.toString()
            val name: String = findViewById<TextView>(R.id.editTextName).text.toString()
            val email: String = findViewById<TextView>(R.id.editTextEmail).text.toString()
            val user = User(0,email,"",name,dni,"")

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Update")
           // builder.setMessage("Update User with: \n Dni: "+ dni + " \n Name: " + name \n Dni: "+ dni + ")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                        applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                try {
                    updateUser(user)
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

        val deleteBtn = findViewById<Button>(R.id.deleteBnt)
        deleteBtn.setOnClickListener {
            val dni: String = findViewById<TextView>(R.id.editTextDni).text.toString()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete")
            builder.setMessage("Are you sure to delete: " + dni + " ?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                        applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                deleteUser(dni)
                Log.v("Edit", "borrao")
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

    private fun getById(userId: Int) {
        Log.v("Getbyid", "Estoy aqui: "+userId)
        val userServiceImpl = UserServiceImpl()
        userServiceImpl.getById(this, userId) { response ->
            run {
                val name: TextView = findViewById(R.id.editTextName)
                val email: TextView = findViewById(R.id.editTextEmail)
                val dni: TextView = findViewById(R.id.editTextDni)
                val url = "http://192.168.203.73:8000/users_image/"//clase
                //val url = "http://192.168.1.129:8000/users_image/"//casa

                name.setText(response?.name ?: "")
                email.setText(response?.email ?: "")
                dni.setText(response?.dni ?: "")
                /*val imageUrl = url + r.url_img
                Picasso.with(context).load(imageUrl).into(img);*/
            }
        }
    }

    private fun deleteUser(userDni: String) {
        val userServiceImpl = UserServiceImpl()
        userServiceImpl.deleteUser(this, userDni) { ->
            run {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun updateUser(user: User) {
        val userServiceImpl = UserServiceImpl()
        userServiceImpl.updateUser(this, user) { ->
            run {
                Log.v("Link", "Iria al List")
                /*val intent = Intent(this, PostDetailActivity::class.java)
                startActivity(intent)*/
            }
        }
    }

    private fun logOutUser(user:User){
        val authServiceImpl = AuthServiceImpl()
        authServiceImpl.logIn(this,user){run{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }}
    }




}
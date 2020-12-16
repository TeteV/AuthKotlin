package com.example.ktlum.AuthService

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.controller.BasicLogin
import com.example.ktlum.controller.FailLogin
import com.example.ktlum.controller.SuccessLogin
import com.example.ktlum.model.User
import org.json.JSONObject


class AuthServiceImpl : IAuthService{


    //Este no funcionaS
    override fun logOut(context: Context, user: User, completionHandler: () -> Unit){
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/logout"
        val userJson: JSONObject = JSONObject()
        userJson.get("api_token")
        val objectRequest = JsonObjectRequest(Request.Method.POST, path, userJson,
                { response ->
                    completionHandler()
                    Log.v("login", response.toString())
                },
                { error ->
                    completionHandler()
                    Log.v("login", "Error")
                })
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun logIn(context: Context, user: User, completionHandler: () -> Unit){
        Log.v("LoginService","Auqi")
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/login"
        val userJson = JSONObject()
        Log.v("LoginService","Auqi1")
        userJson.put("email", user.email )
        userJson.put("password", user.password )
        userJson.put("api_token", user.api_token )
        Log.v("LoginService","Auqi2")
        val objectRequest = JsonObjectRequest(Request.Method.POST, path, userJson,
                { response ->
                    completionHandler()
                    Log.v("LoginService","Auqi3")
                    val plus = response.opt("res")
                    val tokn = response?.opt("api_token").toString()
                    val id_us = response?.opt("id_user").toString()
                    Log.v("LoginService","plus: " + plus)
                    Log.v("login","token: " + tokn)
                    Log.v("login","Id User: " + id_us)
                     if (plus==true){

                         val intent = Intent(context, SuccessLogin::class.java)
                         intent.putExtra("api_token", tokn)
                         intent.putExtra("id_user",id_us)

                         Log.v("VilHolder func", user.api_token)
                         context.startActivity(intent)
                     }else{
                         val intent = Intent(context, FailLogin::class.java)
                         context.startActivity(intent)
                     }
                },
                { error ->
                    completionHandler()
                    Log.v("login", "Error")
                })
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }


    override fun createUser(context: Context, user:User, completionHandler: () -> Unit) {
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/signin"
        val postJson: JSONObject = JSONObject()
        postJson.put("id", 0)
        postJson.put("dni",user.dni)
        postJson.put("name",user.name)
        postJson.put("email",user.email)
        postJson.put("password",user.password)

        val objectRequest = JsonObjectRequest(Request.Method.POST, path, postJson,
                { response -> completionHandler()
                Log.v("AddUser","Creado")
                },
                { error -> completionHandler()
                    Log.v("AddUser","Roto")
                })
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }


}

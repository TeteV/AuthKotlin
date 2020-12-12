package com.example.ktlum.AuthService

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.controller.BasicLogin
import com.example.ktlum.controller.SuccessLogin
import com.example.ktlum.model.User
import org.json.JSONObject


class AuthServiceImpl : IAuthService{
    var allok = false


    //Este no funcionaS
    override fun logOut(context: Context, user: User, completionHandler: () -> Unit){
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/logout"
        val userJson: JSONObject = JSONObject()
        userJson.get("api_token")
        //userJson.put("password", user.password )
        val objectRequest = JsonObjectRequest(Request.Method.POST, path, userJson,
                { response ->
                    completionHandler()
                    Log.v("login", response.toString())
                    var plus = response.names()
                    var pluskis = plus.get(1)
                    if (pluskis.equals("token")){
                        allok = true
                    }else{ Log.v("login","false")}
                },
                { error ->
                    completionHandler()
                    Log.v("login", "Error")
                })
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun logIn(context: Context, user: User, completionHandler: () -> Unit){
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/login"
        val userJson: JSONObject = JSONObject()
        userJson.put("email", user.email )
        userJson.put("password", user.password )
        val objectRequest = JsonObjectRequest(Request.Method.POST, path, userJson,
                { response ->
                    completionHandler()
                    Log.v("login", response.toString())
                    var plus = response.names()
                    var pluskis = plus.get(1)
                     if (pluskis.equals("token")){
                         allok = true
                     }else{ Log.v("login","false")}
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
                Log.v("AddUser","Creado")},
                { error -> completionHandler()
                    Log.v("AddUser","Roto")})
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }



}

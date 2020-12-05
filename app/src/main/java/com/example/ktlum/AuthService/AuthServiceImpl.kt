package com.example.ktlum.AuthService

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.model.User
import org.json.JSONObject

class AuthServiceImpl : IAuthService{


    override fun logIn(context: Context,user: User,completionHandler: () -> Unit){
        val path = AuthSingleton.getInstance(context).baseUrl + "/api/login"
        Log.v("login",path)
        val userJson: JSONObject = JSONObject()
        userJson.put("email", user.email )
        userJson.put("password", user.password )
        Log.v("login","Llego al object REque")
        val objectRequest = JsonObjectRequest(Request.Method.POST, path, userJson,
            { response -> completionHandler()
                Log.v("login",response.toString())
                //here need an IF, if true go to success page, if false, fo to user or pwd incorrect
            },
            { error -> completionHandler()
                Log.v("login","roto")
            })
        AuthSingleton.getInstance(context).addToRequestQueue(objectRequest)
        Log.v("login","logueado como: " + userJson)

       // getToken();
    }

    private fun getToken(){

    }
}

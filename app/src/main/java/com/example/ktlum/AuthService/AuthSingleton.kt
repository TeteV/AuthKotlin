package com.example.ktlum.AuthService

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class AuthSingleton constructor(context: Context){
   // val baseUrl = "http://192.168.43.210:8000" //clase
     val baseUrl = "http://192.168.1.129:8000" //casa

    companion object {
        @Volatile
        private var INSTANCE: AuthSingleton? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: AuthSingleton(context).also {
                        INSTANCE = it
                    }
                }
    }

    val requestQueue: RequestQueue by lazy {
        // applicationContext is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }
}
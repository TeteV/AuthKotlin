package com.example.ktlum.UserService

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.model.User
import org.json.JSONObject

class UserServiceImpl : IUserService {

    override fun getByDni(context: Context, userDni: String, completionHandler: (response: User?) -> Unit) {
        val path = UserSingleton.getInstance(context).baseUrl + "/api/user/" + userDni
        val objectRequest = JsonObjectRequest(
            Request.Method.GET, path, null,
            { response ->
                if(response == null) {
                    completionHandler(null)
                }

                val requestedPost= response.getJSONObject("user")

                val id = requestedPost.getInt("id")
                val email = requestedPost.getString("email")
                val dni = requestedPost.getString("dni")
                val name = requestedPost.getString("name")
                val password = requestedPost.getString("password")

                val user = User(id,email,password,name,dni)
                completionHandler(user)
            },
            { error ->
                Log.v("holi","Error en getById")
                completionHandler(null)
            })
       UserSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    /*override fun getDniById(context: Context, userId: Int, completionHandler: (response: User?) -> Unit){

    }*/

    override fun deleteUser(context: Context, userDni: String, completionHandler: () -> Unit) {
        val path = UserSingleton.getInstance(context).baseUrl + "/api/delete-user/" + userDni
        val objectRequest = JsonObjectRequest(Request.Method.DELETE, path, null,
                { response ->
                    Log.v("borro", "se borró")
                    completionHandler()
                },
                { error ->
                    Log.v("borro", "error al borrar")
                    completionHandler()
                })
        UserSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

    override fun updateUser(context: Context, user : User, completionHandler: () -> Unit) {
        val path = UserSingleton.getInstance(context).baseUrl + "/api/update-user/" + user.dni
        val userJson: JSONObject = JSONObject()
        userJson.put("dni", user.dni)
        userJson.put("name", user.name)
        userJson.put("email", user.email)

        val objectRequest = JsonObjectRequest(Request.Method.PUT, path, userJson,
                { response ->
                    completionHandler()
                },
                { error ->
                    completionHandler()
                })
        UserSingleton.getInstance(context).addToRequestQueue(objectRequest)
    }

}
package com.example.ktlum.UserService

import android.content.Context
import com.example.ktlum.model.User

interface IUserService {
    fun getByDni(context: Context, userDni: String, completionHandler: (response: User?) -> Unit)
    fun deleteUser(context: Context, userDni: String, completionHandler: () -> Unit)
    fun updateUser(context: Context, user : User, completionHandler: () -> Unit)
}
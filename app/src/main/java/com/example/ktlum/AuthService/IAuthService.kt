package com.example.ktlum.AuthService

import android.content.Context
import com.example.ktlum.model.User

interface IAuthService {

    fun logIn(context: Context, user: User, completionHandler: () -> Unit)
    fun logOut(context: Context, user: User, completionHandler: () -> Unit)
    fun createUser(context: Context, user:User, completionHandler: () -> Unit)
}
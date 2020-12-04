package com.example.ktlum.AuthService

import android.content.Context
import com.example.ktlum.model.User

interface IAuthService {

    fun logIn(ontext: Context, user: User, completionHandler: () -> Unit)
}
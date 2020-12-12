package com.example.ktlum.RoomService

import android.content.Context
import com.example.ktlum.model.Room

interface IRoomService {
    fun getAll(context: Context, completionHandler: (response: ArrayList<Room>?) -> Unit)
    fun getByNum(context: Context, num: Int, completionHandler: (response: Room?) -> Unit)
}
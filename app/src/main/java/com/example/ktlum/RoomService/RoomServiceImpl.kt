package com.example.ktlum.RoomService

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.model.Room
import org.json.JSONArray

class RoomServiceImpl : IRoomService{

    override fun getAll(context: Context, completionHandler: (response: ArrayList<Room>?) -> Unit) {
        val path = RoomSingleton.getInstance(context).baseUrl + "/api/rooms"
        Log.v("Nestor","Holioli")
        val arrayRequest = JsonObjectRequest(Request.Method.GET, path, null,
            { response ->
                Log.v("Nestor","Estamos en el response")
                Log.v("Nestor",response.toString())

                var rooms: ArrayList<Room> = ArrayList()
                //val roomArray = response.getJSONObject("room")
                val roomArray : JSONArray = response.getJSONArray("room")
                for (i in 0 until roomArray.length()) {
                    val room = roomArray.getJSONObject(i)
                    val num = room.getInt("num")
                    val numPpl = room.getInt("num_ppl")
                    val size = room.getInt("size")
                    rooms.add(Room(num,numPpl,size,true,"",0))

                }
                Log.v("Nestor",rooms.toString())
                completionHandler(rooms)

                /*var rooms: ArrayList<Room> = ArrayList()
                val roomArray : JSONArray = response.getJSONArray("rooms")*/
                /*for (i in 0 until roomArray.length()) {
                    val room = roomArray.getJSONObject(i)
                    val num = room.getInt("num")
                    val num_ppl = room.getInt("num_ppl")
                    val size = room.getInt("size")
                    rooms.add(Room(num,num_ppl,size,true,"",0))

                }*/
                //Log.v("Nestor",rooms.toString())
                //completionHandler(rooms)
            },
            { error ->
                Log.v("Nestor","EStamos en el error")
                Log.v("Nestor","ooo "+error.toString())
                completionHandler(ArrayList<Room>())
            })
        RoomSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    /*override fun getByPpl(context: Context, numPpl: Int, completionHandler: (response: Room?) -> Unit){

    }*/
}
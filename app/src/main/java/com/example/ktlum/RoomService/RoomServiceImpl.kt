package com.example.ktlum.RoomService

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ktlum.model.Room
import com.google.gson.JsonArray
import org.json.JSONArray

class RoomServiceImpl : IRoomService{

    override fun getAll(context: Context, completionHandler: (response: ArrayList<Room>?) -> Unit) {
        val path = RoomSingleton.getInstance(context).baseUrl + "/api/rooms"
        Log.v("Nestor","Holioli")
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
            { response ->
                Log.v("Nestor","Estamos en el response")
                //Log.v("Nestor",response.toString())

                val roomArray : JSONArray = response
                var rooms: ArrayList<Room> = ArrayList()
                for (i in 0 until roomArray.length()) {
                    val room = roomArray.getJSONObject(i)
                    val num = room.getInt("num")
                    val numPpl = room.getInt("num_ppl")
                    val size = room.getInt("size")
                    rooms.add(Room(num,numPpl,size,true,"",0))

                }
                //Log.v("Nestor",rooms.toString())
                completionHandler(rooms)
            },
            { error ->
                Log.v("Nestor","EStamos en el error")
                Log.v("Nestor","ooo "+error.toString())
                completionHandler(ArrayList<Room>())
            })
        RoomSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    override fun getByNum(context: Context, num: Int, completionHandler: (response: Room?) -> Unit) {
        val path = RoomSingleton.getInstance(context).baseUrl + "/api/rooms/" + num
        val arrayRequest = JsonArrayRequest(Request.Method.GET, path, null,
            { response ->
                if(response == null) {
                    completionHandler(null)
                }

                val resquestRoom = response.getJSONObject(0)
                val num_room = resquestRoom.getInt("num")
                val num_ppl = resquestRoom.getInt("num_ppl")
                val size = resquestRoom.getInt("size")
                val avaible = resquestRoom.getString("avaible").toBoolean()
                val url = resquestRoom.getString("url_img")

                val room = Room(num_room,num_ppl,size,avaible,url,0)
                completionHandler(room)
            },
            { error ->
                Log.v("holi","Error en getBynum")
                completionHandler(null)
            })
        RoomSingleton.getInstance(context).addToRequestQueue(arrayRequest)
    }

    /*override fun getByPpl(context: Context, numPpl: Int, completionHandler: (response: Room?) -> Unit){

    }*/
}
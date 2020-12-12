package com.example.ktlum.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktlum.R
import com.example.ktlum.RoomService.RoomServiceImpl
import com.example.ktlum.model.Room

class RoomList : AppCompatActivity() {
    private lateinit var rooms: ArrayList<Room>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RoomAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list)

        rooms = ArrayList<Room>()
        viewManager = LinearLayoutManager(this)
        viewAdapter = RoomAdapter(rooms, this)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRooms)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        listeners()
        getAllRooms()
    }

    private fun listeners(){
        val backBtn = findViewById<Button>(R.id.BackBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, SuccessLogin::class.java)
            startActivity(intent)
        }

        val userBtn = findViewById<Button>(R.id.userBtn)
        userBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllRooms(){
        val roomServiceImpl = RoomServiceImpl()
        roomServiceImpl.getAll(this) { response ->
            run {
                Log.v("Nestor",response.toString())
                if (response != null) {
                    viewAdapter.roomList = response
                }
                viewAdapter.notifyDataSetChanged()
            }
        }
    }



}

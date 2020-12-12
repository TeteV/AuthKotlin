package com.example.ktlum.controller

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktlum.R
import com.example.ktlum.model.Room

class RoomAdapter (var roomList: ArrayList<Room>, val context: Context) : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_room_list_template, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(roomList[position], context)
    }

    override fun getItemCount(): Int {
        return roomList.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(r:Room, context: Context){
            val roomnum: TextView = itemView.findViewById(R.id.textViewNRoom)
            val roomppl: TextView = itemView.findViewById(R.id.textViewNPers)
            val roomsize: TextView = itemView.findViewById(R.id.textViewSize)

            roomnum.text = r.num.toString()
            roomppl.text = r.num_ppl.toString()
            roomsize.text = r.size.toString()
            itemView.setOnClickListener {
                val intent = Intent(context, RoomDetails::class.java)
                intent.putExtra("num", r.num)
                intent.putExtra("num_ppl", r.num_ppl)
                intent.putExtra("num_ppl", r.size)
                Log.v("VilHolder func", r.num.toString() + r.num_ppl.toString() + r.size.toString())
                context.startActivity(intent)
            }
        }
    }

}
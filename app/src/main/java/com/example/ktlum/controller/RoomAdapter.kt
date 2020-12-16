package com.example.ktlum.controller

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktlum.R
import com.example.ktlum.model.Room
import com.squareup.picasso.Picasso

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
          val url = "http://192.168.203.73:8000/rooms_image/"//clase
            // val url = "http://192.168.1.129:8000/rooms_image/" //casa
            val roomnum: TextView = itemView.findViewById(R.id.textViewNRoom)
            val roomppl: TextView = itemView.findViewById(R.id.textViewNPers)
            val roomsize: TextView = itemView.findViewById(R.id.textViewSize)
            val img: ImageView = itemView.findViewById(R.id.imageView)

            roomnum.text = r.num.toString()
            roomppl.text = r.num_ppl.toString()
            roomsize.text = r.size.toString()

            val imageUrl = url + r.url_img
            Picasso.with(context).load(imageUrl).into(img);
            itemView.setOnClickListener {

                val intent = Intent(context, RoomDetails::class.java)
                intent.putExtra("num", r.num)
                intent.putExtra("num_ppl", r.num_ppl)
                intent.putExtra("num_ppl", r.size)
                //intent.putExtra("id_user", id_us)
                context.startActivity(intent)
            }
        }
    }

}
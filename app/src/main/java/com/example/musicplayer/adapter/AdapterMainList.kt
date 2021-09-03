package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.data.MusicModel
import kotlinx.android.synthetic.main.item_main_list.view.*
class AdapterMainList : RecyclerView.Adapter<AdapterMainList.MusicHolder>() {

    private var listItems: ArrayList<MusicModel> = ArrayList()

    class MusicHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
        return MusicHolder(v)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAllItems(music: List<MusicModel>){
        listItems.addAll(music)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        val itemList = listItems[position]
        holder.itemView.image_main_list.setImageResource(itemList.image)
        holder.itemView.name_group_main_list.text = itemList.nameGroup
        holder.itemView.name_song_main_list.text = itemList.nameSong
    }

    override fun getItemCount() = listItems.size
}
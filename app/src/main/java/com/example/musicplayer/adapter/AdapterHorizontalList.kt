package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.data.MusicHorizontalModel
import kotlinx.android.synthetic.main.item_horizontal_list.view.*

class AdapterHorizontalList : RecyclerView.Adapter<AdapterHorizontalList.MusicHolder>() {

    private var listItems: ArrayList<MusicHorizontalModel> = ArrayList()

    class MusicHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_list, parent, false)
        return MusicHolder(v)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAllItemsTwo(musicHorizontals: List<MusicHorizontalModel>) {
        listItems.addAll(musicHorizontals)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        val itemList = listItems[position]
        holder.itemView.image_horizontal.setImageResource(itemList.imageHorizontal)
        holder.itemView.name_group_horizontal.text = itemList.nameGroupHorizontal
        holder.itemView.name_song_horizontal.text = itemList.nameSongHorizontal
    }

    override fun getItemCount() = listItems.size
}
package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.data.SongInformation
import kotlinx.android.synthetic.main.item_main_list.view.*

class AdapterMaiList : RecyclerView.Adapter<AdapterMaiList.HolderClass>() {
    var myListSong = ArrayList<SongInformation>()

    class HolderClass(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
        return HolderClass(v)
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        val song = myListSong[position]
        holder.itemView.name_song_main_list.text = song.Title
        holder.itemView.name_group_main_list.text = song.Author
        try {
            val mr = MediaMetadataRetriever()
            mr.setDataSource(song.SongUrl)
            val data = mr.embeddedPicture ?: ByteArray(0)
            mr.release()
            holder.itemView.image_main_list.setImageBitmap(
                BitmapFactory.decodeByteArray(
                    data,
                    0,
                    data.size
                )
            )
        } catch (error: Throwable) {
            holder.itemView.image_main_list.setImageBitmap(null)
            error.printStackTrace()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAllSongs(music: List<SongInformation>) {
        myListSong.addAll(music)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return myListSong.size
    }
}
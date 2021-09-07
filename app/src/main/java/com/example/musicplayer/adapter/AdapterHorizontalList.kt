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
import kotlinx.android.synthetic.main.item_horizontal_list.view.*

class AdapterHorizontalList :
    RecyclerView.Adapter<AdapterHorizontalList.HolderClassTwo>() {
    var myListSong = ArrayList<SongInformation>()

    class HolderClassTwo(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClassTwo {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_list, parent, false)
        return HolderClassTwo(v)
    }

    override fun onBindViewHolder(holder: HolderClassTwo, position: Int) {
        val song = myListSong[position]
        holder.itemView.name_song_horizontal.text = song.Title
        holder.itemView.name_group_horizontal.text = song.Author
        try {
            val mr = MediaMetadataRetriever()
            mr.setDataSource(song.SongUrl)
            val data = mr.embeddedPicture ?: ByteArray(0)
            holder.itemView.image_horizontal.setImageBitmap(
                BitmapFactory.decodeByteArray(
                    data,
                    0,
                    data.size
                )
            )
            mr.release()
        } catch (error: Throwable) {
            holder.itemView.image_horizontal.setImageBitmap(null)
            error.printStackTrace()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAllSongsHorizontal(music: List<SongInformation>) {
        myListSong.addAll(music)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return myListSong.size
    }
}
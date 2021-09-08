package com.example.musicplayer.fragment

import android.content.ContentResolver
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.adapter.AdapterHorizontalList
import com.example.musicplayer.adapter.AdapterMaiList
import com.example.musicplayer.data.SongInformation
import kotlinx.android.synthetic.main.fragment_main_list.*

class FragmentMainList : Fragment(R.layout.fragment_main_list) {

    private val listSongs = mutableListOf<SongInformation>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LinearSnapHelper().attachToRecyclerView(rv_main)
        loadSong()
    }

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_list_horizontal ->
                displayHorizontalSongs()
            R.id.menu_main ->
                displayVerticalSongs()
        }
        return true
    }

    private fun loadSong() {
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DISPLAY_NAME
        )
        val selection = MediaStore.Audio.Media.IS_MUSIC + "!=0"
        val resolver: ContentResolver = requireActivity().contentResolver
        val rs = resolver.query(uri, projection, selection, null, null)
        listSongs.clear()
        if (rs != null) {
            while (rs.moveToNext()) {
                val url = rs.getString(rs.getColumnIndex(MediaStore.Audio.Media.DATA))
                val author = rs.getString(rs.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                val title = rs.getString(rs.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
                listSongs.add(SongInformation(id.toLong(), title, author, url))
            }
        }
        rs?.close()
        displayVerticalSongs()
    }

    private fun displayVerticalSongs() {
        val adapter = AdapterMaiList()
        rv_main.adapter = adapter
        listSongs.forEach { _ ->
            adapter.addAllSongs(mutableListOf(listSongs.random()))
        }
        rv_main.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        checkSongsEmpty()

        val resId: Int = R.anim.layout_animation_fall_down
        val animation: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(requireContext(), resId)
        rv_main.layoutAnimation = animation

    }

    private fun displayHorizontalSongs() {
        val adapter = AdapterHorizontalList()
        listSongs.forEach { _ ->
            adapter.addAllSongsHorizontal(mutableListOf(listSongs.random()))
        }
        rv_main.adapter = adapter
        rv_main.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        checkSongsEmpty()
    }

    private fun checkSongsEmpty() {
        if (listSongs.isEmpty()) {
            text_information.text = "Композицій на пристрої не знайдено"
        }
    }
}

package com.example.musicplayer.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.R
import com.example.musicplayer.adapter.AdapterHorizontalList
import com.example.musicplayer.adapter.AdapterMainList
import com.example.musicplayer.data.MusicHorizontalModel
import com.example.musicplayer.data.MusicModel
import com.example.musicplayer.utils.appMainActivity
import kotlinx.android.synthetic.main.fragment_main_list.*

class MainListFragment : FragmentBase(R.layout.fragment_main_list) {

    private var adapterMusic = AdapterMainList()
    private var adapterMusicTwo = AdapterHorizontalList()

    override fun onResume() {
        super.onResume()
        initFunTwo()
        initFun()
        funClick()
    }

    private fun funClick() {
        float_right.setOnClickListener {
            rc_view_music_two.visibility = View.VISIBLE
            rc_view_music.visibility = View.GONE
        }
        float_left.setOnClickListener {
            rc_view_music.visibility = View.VISIBLE
            rc_view_music_two.visibility = View.GONE
        }
    }

    private fun initFunTwo() {
        val listMainTwo = arrayListOf<MusicHorizontalModel>()
        listMainTwo.add(MusicHorizontalModel(R.drawable.image_two, "ОЕ", "Тільки ти"))
        listMainTwo.add(MusicHorizontalModel(R.drawable.image_two, "Назва групи", "Назва пісні"))
        listMainTwo.add(MusicHorizontalModel(R.drawable.image_three, "Назва групи", "Назва пісні"))

        rc_view_music_two.adapter = adapterMusicTwo
        rc_view_music_two.layoutManager =
            LinearLayoutManager(appMainActivity, LinearLayoutManager.HORIZONTAL, false)
        adapterMusicTwo.addAllItemsTwo(listMainTwo)
    }

    private fun initFun() {
        val listMain = arrayListOf<MusicModel>()
        listMain.add(MusicModel(R.drawable.image_one, "ОЕ", "Тільки ти"))
        listMain.add(MusicModel(R.drawable.image_two, "Назва групи", "Назва пісні"))
        listMain.add(MusicModel(R.drawable.image_three, "Назва групи", "Назва пісні"))
        listMain.add(MusicModel(R.drawable.image_four, "Назва групи", "Назва пісні"))
        listMain.add(MusicModel(R.drawable.image_five, "Назва групи", "Назва пісні"))

        rc_view_music.adapter = adapterMusic
        rc_view_music.layoutManager = LinearLayoutManager(appMainActivity)
        adapterMusic.addAllItems(listMain)
    }
}

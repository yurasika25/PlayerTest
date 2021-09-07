package com.example.musicplayer.utils

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.musicplayer.fragment.FragmentMainList

fun checkReadSongsPermission(activity: AppCompatActivity) {
    if (activity.checkSelfPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 111
        )
    } else {
        activity.replaceFragment(FragmentMainList(), false)
    }
}

fun onReadSongsPermissionResult(activity: AppCompatActivity) {
    if (activity.checkSelfPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        activity.replaceFragment(FragmentMainList(), false)
    }
}

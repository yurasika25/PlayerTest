package com.example.musicplayer.utils

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun checkPermissionCode(): Boolean {
    val READ_EXTERNAL_PERMISSION: Int =
        ContextCompat.checkSelfPermission(
            appMainActivity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    if (READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(
            appMainActivity,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            appMainActivity.PERMISSION_READ
        )
        return false
    }
    return true
}



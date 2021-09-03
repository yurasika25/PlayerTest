package com.example.musicplayer.utils

import android.Manifest
import androidx.core.app.ActivityCompat


fun requestStoragePermission() {
    if (ActivityCompat.shouldShowRequestPermissionRationale(
            appMainActivity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    ) {
        ActivityCompat.requestPermissions(
            appMainActivity,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            STORAGE_PERMISSION_CODE
        )
    }
}


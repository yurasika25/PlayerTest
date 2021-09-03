package com.example.musicplayer.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.R
import com.example.musicplayer.fragment.MainListFragment
import com.example.musicplayer.utils.appMainActivity
import com.example.musicplayer.utils.checkPermissionCode
import com.example.musicplayer.utils.replaceFragment
import com.example.musicplayer.utils.showToast

class MainActivity : AppCompatActivity() {

    val PERMISSION_READ = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appMainActivity = this
        if (checkPermissionCode()) {
            replaceFragment(MainListFragment(), false)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            appMainActivity.PERMISSION_READ -> {
                if (grantResults.isNotEmpty() && permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                    if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        showToast("Будь ласка, надайте дозвіл на зберігання та читання Медіа файлів")
                    } else {
                        replaceFragment(MainListFragment(), false)
                    }
                }
            }
        }
    }
}
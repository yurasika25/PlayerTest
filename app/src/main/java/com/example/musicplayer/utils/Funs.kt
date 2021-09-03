package com.example.musicplayer.utils

import android.widget.Toast

fun showToast(message: String) {
    Toast.makeText(appMainActivity, message, Toast.LENGTH_SHORT).show()
}

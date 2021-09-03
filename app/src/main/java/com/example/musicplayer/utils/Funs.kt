package com.example.musicplayer.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.musicplayer.R

fun showToast(message: String) {
    Toast.makeText(appMainActivity, message, Toast.LENGTH_SHORT).show()
}
fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        appMainActivity.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.mainContainer,
                fragment
            ).commit()
    } else {
        appMainActivity.supportFragmentManager.beginTransaction()
            .replace(
                R.id.mainContainer,
                fragment
            ).commit()
    }
}


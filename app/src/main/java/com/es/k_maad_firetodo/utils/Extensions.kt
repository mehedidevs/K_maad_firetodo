package com.es.k_maad_firetodo.utils

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment


fun ImageView.hide() {
    visibility = View.GONE
}

fun Button.hideBtn() {
    visibility = View.GONE
}


fun Fragment.toast(msg: String?) {
    Toast.makeText(requireContext(), "$msg", Toast.LENGTH_LONG).show()
}




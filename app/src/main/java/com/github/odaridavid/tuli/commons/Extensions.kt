package com.github.odaridavid.tuli.commons

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun View.showSnackBar(content: String) {
    Snackbar.make(this, content, Snackbar.LENGTH_LONG).show()
}

fun Context.showToast(content: String) {
    Toast.makeText(this, content, Toast.LENGTH_LONG).show()
}
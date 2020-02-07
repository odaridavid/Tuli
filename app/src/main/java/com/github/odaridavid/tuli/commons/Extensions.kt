package com.github.odaridavid.tuli.commons

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun View.showSnackBar(content: String) {
    Snackbar.make(this, content, Snackbar.LENGTH_LONG).show()
}

fun Context.showToast(content: String) {
    Toast.makeText(this, content, Toast.LENGTH_LONG).show()
}

inline fun <reified T> Activity.navigateTo(noinline intentExtras: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentExtras?.run {
        intentExtras(intent)
    }
    startActivity(intent)
}

fun requireNotBlank(text: String): String = if (text.isBlank()) "Untitled Task" else text

package com.github.odaridavid.tuli.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.tuli.MainActivity

/**
 * Created By David Odari
 * On 31/01/20
 *
 * Tuli splash screen rendered before opening the default activity
 *
 **/
class TuliSplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
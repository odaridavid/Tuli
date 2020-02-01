package com.github.odaridavid.tuli

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.odaridavid.tuli.commons.showToast

class MainActivity : AppCompatActivity() {

    private val mainToolbar by lazy { findViewById<Toolbar>(R.id.main_toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_authentication) {
            showToast("TODO : Auth")
            true
        } else super.onOptionsItemSelected(item)
    }

}

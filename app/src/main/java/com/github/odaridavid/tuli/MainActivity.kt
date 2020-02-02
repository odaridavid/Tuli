package com.github.odaridavid.tuli

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.odaridavid.tuli.auth.AuthenticationViewModel
import com.github.odaridavid.tuli.commons.AuthError
import com.github.odaridavid.tuli.commons.SignedIn
import com.github.odaridavid.tuli.commons.SignedOut
import com.github.odaridavid.tuli.commons.showToast
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val mainToolbar by lazy { findViewById<Toolbar>(R.id.main_toolbar) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val authenticationViewModel: AuthenticationViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
    }

    override fun onStart() {
        super.onStart()
        observeAuthState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_authentication) {
            authenticationViewModel.executeAuthentication()
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun observeAuthState() {
        authenticationViewModel.authState.observe(this, Observer { state ->
            when (state) {
                SignedIn -> showToast("Signed In")
                SignedOut -> showToast("Signed Out")
                is AuthError -> showToast("${state.t.message}")
            }
        })
    }

}

package com.github.odaridavid.tuli.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
abstract class BaseActivity : AppCompatActivity() {

    abstract val toolbarId: Int

     val toolbar: Toolbar by lazy { findViewById<Toolbar>(toolbarId) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


}
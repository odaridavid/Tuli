package com.github.odaridavid.tuli

import androidx.work.Operation
import com.github.odaridavid.tuli.commons.scheduleDailyRepeatingAlarm
import com.github.odaridavid.tuli.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * Created By David Odari
 * On 31/01/20
 *
 **/
class TuliApplication : DaggerApplication() {

    @field:[Inject Named("task_backup")]
    internal lateinit var taskBackup: Operation

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        AndroidThreeTen.init(this)

        scheduleDailyRepeatingAlarm(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}
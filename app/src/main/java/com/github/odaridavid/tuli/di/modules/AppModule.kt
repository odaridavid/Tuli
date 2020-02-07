package com.github.odaridavid.tuli.di.modules

import android.content.Context
import com.github.odaridavid.tuli.TuliApplication
import dagger.Module
import dagger.Provides

/**
 * Created By David Odari
 * On 02/02/20
 *
 *  Dependancies provided in the scope of the app
 **/
@Module
internal class AppModule {

    @Provides
    internal fun provideContext(application: TuliApplication): Context {
        return application.applicationContext
    }
}
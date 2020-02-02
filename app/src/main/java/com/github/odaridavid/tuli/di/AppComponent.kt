package com.github.odaridavid.tuli.di

import com.github.odaridavid.tuli.TuliApplication
import com.github.odaridavid.tuli.di.modules.ActivityBindingModule
import com.github.odaridavid.tuli.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Main component of the app ,contains modules across the application
 **/
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<TuliApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TuliApplication): AppComponent
    }
}
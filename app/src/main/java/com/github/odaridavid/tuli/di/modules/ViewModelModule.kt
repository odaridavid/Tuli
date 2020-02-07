package com.github.odaridavid.tuli.di.modules

import androidx.lifecycle.ViewModelProvider
import com.github.odaridavid.tuli.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created By David Odari
 * On 02/02/20
 *
 **/
@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
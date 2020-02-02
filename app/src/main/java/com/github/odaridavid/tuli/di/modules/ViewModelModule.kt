package com.github.odaridavid.tuli.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.odaridavid.tuli.auth.AuthenticationViewModel
import com.github.odaridavid.tuli.di.ViewModelKey
import com.github.odaridavid.tuli.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created By David Odari
 * On 02/02/20
 *
 **/
@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(AuthenticationViewModel::class)
    abstract fun bindAuthenticationViewModel(authenticationViewModel: AuthenticationViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
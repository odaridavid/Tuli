package com.github.odaridavid.tuli.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.odaridavid.tuli.commons.AuthState
import com.github.odaridavid.tuli.data.AuthenticationRepository
import javax.inject.Inject

/**
 * Created By David Odari
 * On 02/02/20
 *
 **/
class AuthenticationViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    val authState: LiveData<AuthState>
        get() = _authState

    private val _authState = MutableLiveData<AuthState>()

    fun executeAuthentication() {
        if (!authenticationRepository.isSignedIn())
            authenticationRepository.signIn(_authState)
        else
            authenticationRepository.signOut(_authState)
    }


}
package com.github.odaridavid.tuli.data

import androidx.lifecycle.MutableLiveData
import com.github.odaridavid.tuli.commons.AuthState

/**
 * Created By David Odari
 * On 02/02/20
 *
 **/
interface IAuthenticationSource {

    fun signIn(authState: MutableLiveData<AuthState>)

    fun signOut(authState: MutableLiveData<AuthState>)

}
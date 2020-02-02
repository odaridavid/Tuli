package com.github.odaridavid.tuli.data

import androidx.lifecycle.MutableLiveData
import com.github.odaridavid.tuli.commons.AuthState
import com.github.odaridavid.tuli.commons.SignedOut
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Handles Authentication with firebase
 **/
class FirebaseAuthenticationSource @Inject constructor(val firebaseAuth: FirebaseAuth) :
    IAuthenticationSource {

    override fun signIn(authState: MutableLiveData<AuthState>) {
        //TODO Sign In With Google client
    }

    override fun signOut(authState: MutableLiveData<AuthState>) {
        firebaseAuth.signOut()
        authState.value = SignedOut
    }

}
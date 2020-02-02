package com.github.odaridavid.tuli.data

import android.net.Uri
import com.google.firebase.auth.FirebaseUser

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Handles auth information from firebase
 **/
class FirebaseUserInfo(private val firebaseUser: FirebaseUser?) : IUserInfo {

    override fun isSignedIn(): Boolean = firebaseUser != null

    override fun getEmail(): String? = firebaseUser?.email

    override fun isAnonymous(): Boolean? = firebaseUser?.isAnonymous

    override fun getUid(): String? = firebaseUser?.uid

    override fun getDisplayName(): String? = firebaseUser?.displayName

    override fun getPhotoUrl(): Uri? = firebaseUser?.photoUrl

}
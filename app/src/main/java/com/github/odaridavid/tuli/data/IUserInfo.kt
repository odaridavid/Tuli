package com.github.odaridavid.tuli.data

import android.net.Uri

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Abstracts getting user info regardless of source
 **/
interface IUserInfo {
    fun isSignedIn(): Boolean

    fun getEmail(): String?

    fun isAnonymous(): Boolean?

    fun getUid(): String?

    fun getDisplayName(): String?

    fun getPhotoUrl(): Uri?
}
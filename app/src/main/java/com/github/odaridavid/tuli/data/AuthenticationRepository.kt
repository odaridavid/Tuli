package com.github.odaridavid.tuli.data

import javax.inject.Inject

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Coordinates auth related processes
 **/
class AuthenticationRepository @Inject constructor(
    private val userInfo: IUserInfo,
    private val authenticationSource: IAuthenticationSource
) : IAuthenticationSource by authenticationSource, IUserInfo by userInfo
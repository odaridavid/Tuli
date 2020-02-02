package com.github.odaridavid.tuli.commons

sealed class AuthState

object SignedIn : AuthState()
object SignedOut : AuthState()
class AuthError(val t: Throwable) : AuthState()
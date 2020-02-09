package com.github.odaridavid.tuli.di.scopes

import javax.inject.Scope


/**
 * Scopes dependencies injected into activity to live as long as the activity is alive.
 */
@Scope
annotation class ActivityScope
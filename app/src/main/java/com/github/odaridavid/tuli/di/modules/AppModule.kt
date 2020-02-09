package com.github.odaridavid.tuli.di.modules

import android.content.Context
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Operation
import androidx.work.WorkManager
import com.github.odaridavid.tuli.TuliApplication
import com.github.odaridavid.tuli.notifications.TaskBackupWorker
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created By David Odari
 * On 02/02/20
 *
 *  Dependancies provided in the scope of the app
 **/
@Module
internal class AppModule {

    @Provides
    internal fun provideContext(application: TuliApplication): Context {
        return application.applicationContext
    }

    @Provides
    internal fun provideWorkManager(context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }

    @Provides
    @Named("task_backup")
    internal fun provideTaskBackupWorkRequest(workManager: WorkManager): Operation {
//        val constraints = Constraints.Builder()
//            .setRequiresDeviceIdle(true)
//            .build()
        val backupReq = OneTimeWorkRequestBuilder<TaskBackupWorker>()
            .setInitialDelay(10, TimeUnit.SECONDS)
//            .setConstraints(constraints)
            .build()
        return workManager.enqueue(backupReq)
    }
}
package com.github.odaridavid.tuli.notifications

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created By David Odari
 * On 08/02/20
 *
 **/
class TaskBackupWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result = sendTasksToFirebase()

    private fun sendTasksToFirebase(): Result {
        return Result.success()
    }

}
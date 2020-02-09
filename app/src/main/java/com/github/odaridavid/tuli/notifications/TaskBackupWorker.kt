package com.github.odaridavid.tuli.notifications

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.github.odaridavid.tuli.R

/**
 * Created By David Odari
 * On 08/02/20
 *
 **/
class TaskBackupWorker(
    val context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    companion object {
        const val NOTIFICATION_ID = 1
        val notificationsProvider = NotificationsProvider()
    }

    override fun doWork(): Result = sendTasksToFirebase()

    private fun sendTasksToFirebase(): Result {
        showWorkManagerNotification()
        return Result.success()
    }

    private fun showWorkManagerNotification() {
        notificationsProvider.buildNotification(
            context,
            NOTIFICATION_CHANNELS[ChannelID.TEST]!!,
            NOTIFICATION_ID,
            "Backgrounf Work Notification",
            5,
            "Check Notifications Working As Expected"
        ) { channelId ->
            NotificationCompat.Builder(context, channelId)
                .setContentTitle("Completed Tasks")
                .setContentText("Backing up...")
                .setSmallIcon(R.drawable.ic_hourglass_empty)
        }
    }

}
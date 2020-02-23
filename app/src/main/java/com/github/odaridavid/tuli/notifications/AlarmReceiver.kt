package com.github.odaridavid.tuli.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.github.odaridavid.tuli.R

/**
 * Created By David Odari
 * On 23/02/20
 *
 **/
class AlarmReceiver : BroadcastReceiver() {

    companion object {
        val notificationsProvider = NotificationsProvider()
        const val ALARM_NOTIFICATION_ID = 2
    }

    override fun onReceive(context: Context, p1: Intent?) {
        notificationsProvider.buildNotification(
            context,
            NOTIFICATION_CHANNELS[ChannelID.ALARM]!!,
            ALARM_NOTIFICATION_ID,
            "Alarm Notifications",
            5,
            "Check Alarm Notifications Working As Expected"
        ) { channelId ->
            NotificationCompat.Builder(context, channelId)
                .setContentTitle("Completed Tasks")
                .setContentText("Backing up...")
                .setSmallIcon(R.drawable.ic_hourglass_empty)
        }
    }

}
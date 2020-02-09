package com.github.odaridavid.tuli.notifications

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.core.app.NotificationCompat

/**
 * Created By David Odari
 * On 09/02/20
 *
 **/
class NotificationsProvider {

    fun buildNotification(
        context: Context,
        channelId: String,
        notificationId: Int,
        name: String,
        importanceLvl: Int,
        channelDesc: String,
        notificationBuilder: (String) -> (NotificationCompat.Builder)
    ) {
        val notificationManager = getNotificationManager(context)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val level = when (importanceLvl) {
                1 -> NotificationManager.IMPORTANCE_MIN
                2 -> NotificationManager.IMPORTANCE_LOW
                3 -> NotificationManager.IMPORTANCE_DEFAULT
                4 -> NotificationManager.IMPORTANCE_HIGH
                5 -> NotificationManager.IMPORTANCE_MAX
                else -> NotificationManager.IMPORTANCE_UNSPECIFIED
            }

            notificationManager.createNotificationChannel(
                createNotificationChannel(channelId, name, level, channelDesc)
            )
        }

        notificationManager.notify(notificationId, notificationBuilder(channelId).build())

    }

    private fun getNotificationManager(context: Context): NotificationManager =
        context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

    @TargetApi(android.os.Build.VERSION_CODES.O)
    private fun createNotificationChannel(
        channelID: String,
        channelName: String,
        importanceLvl: Int,
        description: String,
        enableLights: Boolean = true,
        @ColorInt lightColor: Int = Color.CYAN,
        enableVibration: Boolean = true
    ): NotificationChannel {

        return NotificationChannel(channelID, channelName, importanceLvl)
            .apply {
                enableLights(enableLights)
                setLightColor(lightColor)
                enableVibration(enableVibration)
                setDescription(description)
            }
    }

}

enum class ChannelID {
    TEST
}

val NOTIFICATION_CHANNELS: Map<ChannelID, String> by lazy {
    mapOf(ChannelID.TEST to "test_notification_channel")
}
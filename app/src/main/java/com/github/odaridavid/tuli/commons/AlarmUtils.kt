package com.github.odaridavid.tuli.commons

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.github.odaridavid.tuli.notifications.AlarmReceiver
import java.util.*


fun scheduleDailyRepeatingAlarm(context: Context) {

    //Intent to an Alarm Broadcast Receiver handling notifications
    val intent = Intent(context, AlarmReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = System.currentTimeMillis()

    //Test to see whether it will run at 8:40 exact
    calendar.set(Calendar.HOUR_OF_DAY, 20)
    calendar.set(Calendar.MINUTE, 40)

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.setInexactRepeating(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        AlarmManager.INTERVAL_DAY,//Repeat daily
        pendingIntent
    )
}
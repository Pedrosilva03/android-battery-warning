package com.example.lowbatterywarning

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import android.R

class BatteryReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
            val level = intent.getIntExtra("level", -1)
            if (level <= 1) {
                context?.let {
                    sendBatteryNotification(it, level)
                }
                //Toast.makeText(context, "⚠️ Battery level at $level%! The phone will shutdown soon!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun sendBatteryNotification(context: Context, level: Int) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context, "boot_channel")
            .setSmallIcon(R.mipmap.sym_def_app_icon)
            .setContentTitle("Very Low Battery!")
            .setContentText("Battery level at $level%! The phone will shutdown soon!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
    }
}
package com.example.lowbatterywarning

import android.app.NotificationManager
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity

import android.content.Intent
import android.widget.Toast

class MainActivity : ComponentActivity() {
    private lateinit var batteryReceiver: BatteryReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!areNotificationsEnabled(this)) {
            Toast.makeText(this,"Enable app notifications to receive alerts (required)", Toast.LENGTH_LONG).show()
        }

        batteryReceiver = BatteryReceiver()
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryReceiver)
    }
}

fun areNotificationsEnabled(context: Context): Boolean {
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    return notificationManager.areNotificationsEnabled()
}
package com.example.lowbatterywarning

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.util.Log

class BatteryReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
            val level = intent.getIntExtra("level", -1)
            if (level <= 100) {
                Toast.makeText(context, "⚠️ A bateria está em $level%! Vai se desligar em breve", Toast.LENGTH_LONG).show()
            }
        }
    }
}
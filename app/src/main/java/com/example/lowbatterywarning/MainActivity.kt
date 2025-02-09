package com.example.lowbatterywarning

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity

import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Regista o receiver para detectar mudanças de bateria
        val batteryReceiver = BatteryReceiver()
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryReceiver, intentFilter)
    }
}
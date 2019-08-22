package com.example.foregroundservicedemo

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

const val tag : String = "ForegroundService"

class ForegroundService : Service (){

    //this method is triggered when we start our service
    //this will be called as many times Start Service is called
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(tag, "[ onStartCommand ]")
        val inputString = intent?.getStringExtra("start_key")

        val notificationIntent = Intent(this , MainActivity::class.java)
        val pendingIntent : PendingIntent = PendingIntent.getActivity(this , 0 , notificationIntent , 0)

        val notification : Notification = NotificationCompat.Builder(this, channel_id)
            .setContentTitle("Foreground Service")
            .setContentText(inputString)
            .setContentText(inputString)
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1 , notification)

        return START_NOT_STICKY
    }

    //called only once when first time we create a service
    override fun onCreate() {
        Log.v(tag, "[ onCreate ]")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.v(tag, "[ onDestroy ]")
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.v(tag, "[ onBind ]")
        return null
    }

}
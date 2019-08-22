package com.example.foregroundservicedemo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log

const val channel_id : String = "serviceChannel" //our channel id

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.v("App" ,"[ onCreate ]" )
        createNotificationChannel()
    }

    private fun createNotificationChannel (){
        //create notification channel only if we are on android oreo or higher
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(channel_id , "Service Channel" , NotificationManager.IMPORTANCE_DEFAULT)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(serviceChannel)


        }

    }


}
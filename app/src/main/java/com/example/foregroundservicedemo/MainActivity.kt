package com.example.foregroundservicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

const val main_tag : String = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(main_tag, "[ onCreate ]")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //passes the edit text string input to the startService method
    fun startServiceOnClick(mView : View){
        Log.v(main_tag, "[ onClickStart ]")
        val serviceIntent : Intent = Intent(this ,ForegroundService::class.java)
        serviceIntent.putExtra("start_key", editText.text.toString())
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopServiceOnClick(mView : View){
        Log.v(main_tag, "[ onClickStop ]")
        val serviceIntent : Intent = Intent(this , ForegroundService::class.java)
        stopService(serviceIntent)
    }
}

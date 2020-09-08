package com.example.myservice

import android.app.Service
import android.content.Intent
import android.content.res.AssetManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.net.Uri
import kotlinx.android.synthetic.main.activity_main.*

class MyService:Service() {

    private val mbind=DownLoadBinder()
    override fun onBind(p0: Intent?): IBinder? {
        return mbind
    }
    class DownLoadBinder:Binder(){
        private val mediaPlayer=MediaPlayer()
        fun start(uri: Uri) {

        }
        fun end(){
            Log.d("ffff","aaaaa")
        }

    }
}
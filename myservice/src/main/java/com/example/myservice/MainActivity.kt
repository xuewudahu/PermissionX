package com.example.myservice

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.widget.MediaController

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var downloadBinder:MyService.DownLoadBinder

    private val connection=object:ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }


        override fun onServiceConnected(name:ComponentName,service:IBinder) {
            downloadBinder=service as MyService.DownLoadBinder
            downloadBinder.end()

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            val intent1 = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent1.addCategory(Intent.CATEGORY_OPENABLE)
            // 指定只显示照片
            intent1.type = "video/*"
            startActivityForResult(intent1, 1)
            val intent=Intent(this,MyService::class.java)
            bindService(intent,connection, Context.BIND_AUTO_CREATE)
        }
        button2.setOnClickListener {
            unbindService(connection)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    data.data?.let { uri ->
                        // 将选择的照片显示
                        //   val bitmap = getBitmapFromUri(uri)


                        //设置视频控制器
                        videoview.setMediaController(MediaController(this))

                        //播放完成回调
//                        videoview.setOnCompletionListener(MyPlayerOnCompletionListener())

                        //设置视频路径
                        videoview.setVideoURI(uri)

                        //开始播放视频
                        videoview.start()
                    }
                }
            }
        }
    }
}

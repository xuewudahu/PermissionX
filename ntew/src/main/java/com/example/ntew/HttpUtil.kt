package com.example.ntew

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

object HttpUtil{
    fun sendHttpRequest(address:String,listener: HttpCallbackListener){
        thread {
            var connection : HttpURLConnection?=null
            try {
                val response=StringBuilder()
                val url= URL(address) //创建URL对象
                connection= url.openConnection() as HttpURLConnection

                connection.connectTimeout=8000	//设置连接超时
                connection.readTimeout = 8000   //设置读取超时
                val input=connection.inputStream
                val reader=BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                listener.onfinish(response.toString())
            }catch (e:Exception){
                e.printStackTrace()
                listener.onError(e)
            }finally {
                connection?.disconnect()
            }

        }

    }
}

fun main() {
    HttpUtil.sendHttpRequest("wwww.baidu.com",object :HttpCallbackListener{
        override fun onfinish(respon: String) {
            println(respon)
        }

        override fun onError(e: Exception) {
            TODO("Not yet implemented")
        }

    })
}
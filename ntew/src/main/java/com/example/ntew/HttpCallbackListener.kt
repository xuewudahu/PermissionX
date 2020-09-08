package com.example.ntew

import java.lang.Exception

interface HttpCallbackListener {
    fun onfinish(respon:String )
    fun onError(e:Exception)
}
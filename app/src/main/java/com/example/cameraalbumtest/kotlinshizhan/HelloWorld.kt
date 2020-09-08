package com.example.cameraalbumtest.kotlinshizhan

import com.example.cameraalbumtest.kotlin.Get
import com.example.cameraalbumtest.kotlin.main2


fun main(){
    val a= arrayListOf("dfa")
    a.add("d33")
    println("Hello ,World")
    var t=HelloWorld(3,34)
    println(t.isage)
    val e=HelloWorld(3,4)
    println(e.ef("df"))
    println(e.sf())
    println(Color.DFG.rgb())
    val r=Pe()
    r.main()
    val s="school"
    for (a in s){
        println(a)
    }
    println(NAME)
    NAME="dfa"
    println(NAME)
}
 var NAME="zhangsan"

class HelloWorld (val name:Int,val isage:Int){
    val isFdad:Boolean
    get() {
        return name == isage
    }
    fun sf(){
        var s3= Get()
        s3.play()
        main2()
    }
    fun getWarmth(color: Color){
        when(color){
            Color.DFG,Color.ORang->"Ri"
            Color.RED->"sd"
        }
    }
    fun ef(idf:String):Int{
       return when(idf){
            "df","df3"->2
            "ds"->4
           else ->2
        }
    }



}
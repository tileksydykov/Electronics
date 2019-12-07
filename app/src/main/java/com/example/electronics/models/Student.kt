package com.example.electronics.models

import java.util.*

data class Student(
    val id : String,
    var name : String,
    var time : Long
){
    fun getHourMinute():String{
        val d = Date()
        d.time = time
        return d.hours.toString() + ":" + d.minutes.toString()
    }
}
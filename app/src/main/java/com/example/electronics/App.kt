package com.example.electronics

import android.app.Application

import io.paperdb.Paper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(applicationContext)
    }
}git

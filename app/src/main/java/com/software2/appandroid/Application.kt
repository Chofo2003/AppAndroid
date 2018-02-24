package com.software2.appandroid

import android.app.Application
import com.androidnetworking.AndroidNetworking

/**
 * Created by chofo2003 on 24/02/18.
 */

class Application: Application () {
    // El application sirve para inicializar todo.
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}
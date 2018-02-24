package com.software2.appandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.software2.appandroid.repository.Repository
import io.reactivex.functions.Consumer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TEST", "Mensaje")
        val repository = Repository()
        repository.getAllProviders(Consumer {
            Log.d("provider", it.toString())
        }, Consumer {
            Log.d("error", it.toString())
        })
    }
}

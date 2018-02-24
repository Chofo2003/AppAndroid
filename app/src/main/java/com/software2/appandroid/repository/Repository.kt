package com.software2.appandroid.repository

import android.util.Log
import com.google.gson.Gson
import com.software2.appandroid.Models.Provider
import com.software2.appandroid.repository.sources.Firebase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by chofo2003 on 24/02/18.
 */

class Repository {

    val firebaseSource = Firebase()

    fun getAllProviders(observer: Consumer<MutableList<Provider>>, error: Consumer<Throwable>) {
        firebaseSource.getAllProviders()
                .map {
                    val providers : MutableList<Provider> = mutableListOf()
                    it.entrySet().forEach {
                        val id = it.value.asJsonObject.get("id").asString
                        val name = it.value.asJsonObject.get("name").asString
                        val description = it.value.asJsonObject.get("description").asString
                        providers.add(Provider(id ,name ,description))
                    }
                    providers
                }
                // Trabajamos con hilos para evitar la concurrencia, en donde quiero que pasen las cosas y donde las voy a escuchar.
                // Inicio en el hilo I/O unicamente para observar.
                .subscribeOn(Schedulers.io())
                // Cuando termina el observador, se junta con el central para continuar normalmente.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer, error)
    }

    fun getOneProvider(id: String) {

    }

    fun postProvider(provider: Provider) {

    }

    fun updateProvider(provider: Provider) {

    }

    fun deleteProvider(id: String) {

    }
}
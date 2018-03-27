package com.software2.appandroid.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.software2.appandroid.Models.Provider
import com.software2.appandroid.repository.Repository
import io.reactivex.functions.Consumer

/**
 * Created by cgarciarobles on 24/02/18.
 */

class MainViewModel : ViewModel(){

    /*
    Lista de objetos que podran cambiar, tipo provider. MutableLiveData me garantiza estar al dia en los cambios
    El observador del tipo provider en BD.
    */
    val providers = MutableLiveData<MutableList<Provider>>();
    val repository = Repository();

    /*
    Esta funcion tomara los providers para poder ser mostrados en las vistas (res)
    Providers value, tomara la lista completa del observador en MutableLiveData y MutableList
    */
    fun getAllProviders() {
        repository.getAllProviders(Consumer {
            providers.value = it;
        }, Consumer {

        })
    }

}
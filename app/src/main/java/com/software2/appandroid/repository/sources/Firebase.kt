package com.software2.appandroid.repository.sources

import com.google.gson.JsonObject
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import org.json.JSONObject
import java.util.*

/**
 * Created by chofo2003 on 24/02/18.
 */

class Firebase () {
    // Para variables globales y estaticas
    companion object {
        private val BASE_URL = "https://appandroid-7ec5f.firebaseio.com"
        var PROVIDER = "${BASE_URL}/providers.json"
    }

    //Obtener el Json de la URL... Endpoint
    //Devuelve un objeto de tipo Observable
    fun getAllProviders(): Observable<JsonObject> {
        return Rx2AndroidNetworking.get(PROVIDER).build().getObjectObservable(JsonObject::class.java)
    }
}
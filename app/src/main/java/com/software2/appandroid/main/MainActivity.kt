package com.software2.appandroid.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder
import com.software2.appandroid.Models.Provider
import com.software2.appandroid.R
import com.software2.appandroid.databinding.MainActivityBinding

/**
 * Created by cgarciarobles on 24/02/18.
 */
class MainActivity : AppCompatActivity (){

    private lateinit var mainActivityBinding : MainActivityBinding
    private var adapter = RendererRecyclerViewAdapter();

    //Esto se ejecuta al crearse la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Cuando inicie, dibuje este xml, lo hacemos con DataBindingUtil, para que pueda manejar el Binding
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        //el binding me sirve para asociar la vista en forma de objeto (lista en main activity xml)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainActivityBinding.mainViewModel = viewModel
        mainActivityBinding.executePendingBindings()
        setupList()
    }

    private fun setupList() {
        mainActivityBinding.lista.layoutManager = LinearLayoutManager(this)
        adapter.registerRenderer(ViewBinder<Provider>(R.layout.item_main,
                Provider::class.java, this, ViewBinder.Binder { model, finder, payloads ->
            finder.find<TextView>(R.id.textCard, { it.text = model.name})
        }))
        mainActivityBinding.lista.adapter = adapter
    }

    private fun setupObservers() {

    }

    private fun getViewModel() : MainViewModel = mainActivityBinding.mainViewModel!!
}

//contactAdapter.registerRenderer(ViewBinder<Profile>(R.layout.item_contact,
//Profile::class.java, this, ViewBinder.Binder { model, finder, _ ->
//    finder.find<TextView>(R.id.contact_name, { it.text = model.displayName })
//    finder.find<TextView>(R.id.contact_role, { it.text = model.ocupation })
//    finder.find<ImageView>(R.id.contact_image, {
//        Glide.with(this).load(model.avatarUrl)
//                .apply(RequestOptions.circleCropTransform()).into(it)
//    })
//    finder.setOnClickListener(R.id.contact_item_container, { onItemClick(model) })
//}))
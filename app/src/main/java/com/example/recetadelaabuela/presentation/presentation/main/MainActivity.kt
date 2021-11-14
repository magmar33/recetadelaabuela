package com.example.recetadelaabuela.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetadelaabuela.R
import com.example.recetadelaabuela.adapters.RecetasAdapter
import com.example.recetadelaabuela.adapters.RecetasAdapterController
import com.example.recetadelaabuela.domain.Receta
import com.example.recetadelaabuela.presentation.creation.CreationActivity
import com.example.recetadelaabuela.presentation.detail.RecetaDetail
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener, MainController.View,
    RecetasAdapterController {

    private lateinit var fbAdd : FloatingActionButton
    private lateinit var rvRecetas : RecyclerView
    private lateinit var adapterRecetas : RecetasAdapter
    private lateinit var presenter : MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,this)

        fbAdd = findViewById(R.id.fbAdd)
        fbAdd.setOnClickListener(this)

        rvRecetas = findViewById(R.id.rvRecetas)

        adapterRecetas = RecetasAdapter(mutableListOf(), this)
        rvRecetas.layoutManager = LinearLayoutManager(this)
        rvRecetas.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        rvRecetas.setHasFixedSize(true)
        rvRecetas.adapter = adapterRecetas


    }

    override fun onResume() {
        super.onResume()
        presenter.getRecetas()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.fbAdd ->{
            startActivity(Intent(this, CreationActivity::class.java))
            }
        }
    }

    override fun setRecetas(recetas: MutableList<Receta>) {
        adapterRecetas.updateData(recetas)
    }

    override fun removeReceta(receta: Receta) {
        presenter.deleteReceta(receta)
    }

    override fun goToReceta(receta: Receta) {
    val intent = Intent(this, RecetaDetail::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }



}
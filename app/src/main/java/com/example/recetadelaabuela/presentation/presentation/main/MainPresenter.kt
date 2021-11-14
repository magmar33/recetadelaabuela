package com.example.recetadelaabuela.presentation.main

import android.content.Context
import com.example.recetadelaabuela.data.local.MyDatabase
import com.example.recetadelaabuela.data.local.recetas.RecetasEntity
import com.example.recetadelaabuela.domain.Receta

class MainPresenter(val view: MainController.View, val context: Context) : MainController.Presenter {

    private val database = MyDatabase.invoke(context)

    override fun getRecetas() {
        val notes = database.recetasDao().getNotes()
        view.setRecetas(notes.map(RecetasEntity :: convertToReceta).toMutableList())
    }

    override fun deleteReceta(receta: Receta) {
        database.recetasDao().delete(Receta.toConvertEntity(receta))
        getRecetas()
    }


    override fun updateRecetas(receta: Receta) {
        database.recetasDao().update(Receta.toConvertEntity(receta))
        getRecetas()
    }

}
package com.example.recetadelaabuela.presentation.creation

import android.content.Context
import com.example.recetadelaabuela.data.local.MyDatabase
import com.example.recetadelaabuela.domain.Receta

class CreationPresenter (private val view : CreationController.View, context: Context): CreationController.Presenter{

    private var database : MyDatabase = MyDatabase.invoke(context)

    override fun createReceta(receta : Receta) {
        when {
            receta.name.isEmpty() -> {
                view.error("Por favor escribe un nombre")
            }
            receta.steps.isEmpty() -> {
                view.error("Por favor escribe los pasos")
            }
            receta.ingredients.isEmpty() -> {
                view.error("Por favor escribe los ingredientes")
            }
            receta.time.isEmpty() -> {
                view.error("Por favor escribe el tiempo")
            }
            else -> {
                database.recetasDao().insert(Receta.toConvertEntity(receta))
                view.success()
            }
        }

    }

}
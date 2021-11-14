package com.example.recetadelaabuela.presentation.creation

import com.example.recetadelaabuela.domain.Receta

interface CreationController {
    interface  View{
    fun success()
    fun error(msg : String)
    }

    interface Presenter {
        fun createReceta(receta : Receta)
    }


}
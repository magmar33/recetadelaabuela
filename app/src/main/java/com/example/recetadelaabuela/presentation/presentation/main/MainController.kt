package com.example.recetadelaabuela.presentation.main

import com.example.recetadelaabuela.domain.Receta

interface MainController {
    interface View{
        fun setRecetas(recetas : MutableList<Receta>)
    }

    interface Presenter{
        fun getRecetas()
        fun deleteReceta(recetas: Receta)
        fun updateRecetas(recetas: Receta)
    }
}
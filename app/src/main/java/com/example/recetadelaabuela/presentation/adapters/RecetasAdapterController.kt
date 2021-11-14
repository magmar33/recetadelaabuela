package com.example.recetadelaabuela.adapters

import com.example.recetadelaabuela.domain.Receta

interface RecetasAdapterController {
    fun removeReceta(receta: Receta)
    fun goToReceta(receta: Receta)
}
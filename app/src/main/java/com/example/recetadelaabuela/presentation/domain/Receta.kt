package com.example.recetadelaabuela.domain

import com.example.recetadelaabuela.data.local.recetas.RecetasEntity
import java.io.Serializable

data class Receta (
    var recetasId : String,
    var name : String,
    var steps : String,
    var ingredients : String,
    var time : String

): Serializable {
    companion object {
        fun toConvertEntity(receta : Receta) =
            RecetasEntity(
                receta.recetasId,
                receta.name,
                receta.steps,
                receta.ingredients,
                receta.time
            )
    }
}
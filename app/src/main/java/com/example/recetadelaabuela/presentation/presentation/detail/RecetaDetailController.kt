package com.example.recetadelaabuela.presentation.detail

import com.example.recetadelaabuela.domain.Receta

interface RecetaDetailController {
    interface View {
        fun success()
        fun error(msg:String)
    }

    interface Presenter {
        fun saveUpdate(receta : Receta)
    }
}
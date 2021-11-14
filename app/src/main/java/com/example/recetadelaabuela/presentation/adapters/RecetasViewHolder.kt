package com.example.recetadelaabuela.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetadelaabuela.R

class RecetasViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tvSteps = view.findViewById<TextView>(R.id.tvSteps)
    val tvIngredients = view.findViewById<TextView>(R.id.tvIngredients)
    val tvTime = view.findViewById<TextView>(R.id.tvTime)

}
package com.example.recetadelaabuela.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recetadelaabuela.R
import com.example.recetadelaabuela.domain.Receta

class RecetasAdapter(var recetas : MutableList<Receta>, private val controller: RecetasAdapterController) : RecyclerView.Adapter<RecetasViewHolder>(){

    fun updateData(recetas : MutableList<Receta>){
        this.recetas = recetas
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recetas, parent, false)
        return  RecetasViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
        val receta = recetas[position]

        holder.tvName.text = receta.name
        holder.tvSteps.text = receta.steps
        holder.tvIngredients.text = receta.ingredients
        holder.tvTime.text = receta.time

        holder.itemView.setOnLongClickListener {
            controller.removeReceta(receta)
            true
        }

        holder.itemView.setOnClickListener {
            controller.goToReceta(receta)
        }
    }

    override fun getItemCount(): Int = recetas.size

}
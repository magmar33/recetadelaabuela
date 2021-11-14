package com.example.recetadelaabuela.data.local.recetas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recetadelaabuela.domain.Receta

@Entity(tableName = "recetas")
data class RecetasEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "recetasId") var recetasId : String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "steps") var steps: String,
    @ColumnInfo(name = "ingredients") var ingredients: String,
    @ColumnInfo(name = "time") var time: String
    ){
    companion object{
        fun convertToReceta(recetasEntity: RecetasEntity) =
            Receta(
                recetasEntity.recetasId,
                recetasEntity.name,
                recetasEntity.steps,
                recetasEntity.ingredients,
                recetasEntity.time
            )
    }
}
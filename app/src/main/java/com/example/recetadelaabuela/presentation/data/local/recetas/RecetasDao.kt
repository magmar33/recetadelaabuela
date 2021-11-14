package com.example.recetadelaabuela.data.local.recetas

import androidx.room.*

@Dao
interface RecetasDao {

    @Insert
    fun insert(recetas: RecetasEntity)

    @Update
    fun update(recetas: RecetasEntity)

    @Delete
    fun delete(recetas: RecetasEntity)

    @Query("select * from recetas order by name asc")
    fun getNotes(): List<RecetasEntity>

}
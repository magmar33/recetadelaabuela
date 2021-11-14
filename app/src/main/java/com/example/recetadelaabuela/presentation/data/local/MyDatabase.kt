package com.example.recetadelaabuela.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recetadelaabuela.data.local.recetas.RecetasDao
import com.example.recetadelaabuela.data.local.recetas.RecetasEntity
import com.example.recetadelaabuela.data.local.user.UserDao
import com.example.recetadelaabuela.data.local.user.UserEntity


@Database(
    entities = [UserEntity::class, RecetasEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao
    abstract fun recetasDao(): RecetasDao

    companion object{
        @Volatile
        private var instance : MyDatabase? = null
        private val LOCK = Any() //Cualquiera

        operator  fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance ?: buildDatabase(context)
                    .also {
                        instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MyDatabase::class.java,"mydatabase.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}
package com.example.clase18_10.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clase18_10.model.Alumno

@Database(entities = [Alumno::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun alumnoDao(): AlumnoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "alumnos_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

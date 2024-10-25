package com.example.clase18_10.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.clase18_10.model.Alumno

@Dao
interface AlumnoDao {

    @Insert
    suspend fun insertAlumno(alumno: Alumno)

    @Query("DELETE FROM alumnos")
    suspend fun clearTable()

    @Query("SELECT * FROM alumnos")
    suspend fun getAllAlumnos(): List<Alumno>
}



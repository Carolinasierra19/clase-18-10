package com.example.clase18_10.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.clase18_10.model.Alumno

//dao es data class object
@Dao
interface AlumnoDao {

    @Insert
    suspend fun insertAlumno(alumno: Alumno)

    @Query("SELECT * FROM alumnos")
    suspend fun getAllAlumnos(): List<Alumno>
}

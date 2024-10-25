package com.example.clase18_10.repository

import com.example.clase18_10.dataBase.AlumnoDao
import com.example.clase18_10.model.Alumno

class AlumnoRepository(private val alumnoDao: AlumnoDao) {

    suspend fun clearAndInsertAlumno(alumno: Alumno) {
        alumnoDao.clearTable()  // Limpiar la tabla
        alumnoDao.insertAlumno(alumno)  // Insertar el alumno
    }

    suspend fun getAllAlumnos(): List<Alumno> {
        return alumnoDao.getAllAlumnos()
    }
}



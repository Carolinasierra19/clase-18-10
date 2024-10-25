package com.example.clase18_10.repository

import com.example.clase18_10.AlumnoProvider
import com.example.clase18_10.dataBase.AlumnoDao
import com.example.clase18_10.model.Alumno


class AlumnoRepository(private val alumnoDao: AlumnoDao) {

    suspend fun clearAndInsertInitialAlumnos() {
        alumnoDao.clearTable()  // Limpiar la tabla
        val initialAlumnos = AlumnoProvider.getInitialAlumnos()
        initialAlumnos.forEach { alumnoDao.insertAlumno(it) }  // Insertar alumnos iniciales
    }

    suspend fun getAllAlumnos(): List<Alumno> {
        return alumnoDao.getAllAlumnos()
    }
}




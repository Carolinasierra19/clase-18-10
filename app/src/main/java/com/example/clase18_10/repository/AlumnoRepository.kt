package com.example.clase18_10.repository

import com.example.clase18_10.model.Alumno

class AlumnoRepository {

    fun getAlumnos(): List<Alumno> {
        return listOf(
            Alumno(1, "Juan", "Pérez", "Buenos Aires", "1000"),
            Alumno(2, "María", "Gómez", "Córdoba", "2000"),
            Alumno(3, "Carlos", "Fernández", "Rosario", "3000"),
            Alumno(4, "Ana", "López", "Mendoza", "4000"),
            Alumno(5, "Mara", "Gonzales", "Buenos Aires", "1000"),
            Alumno(6, "Carolina", "Sierra", "Mendoza", "4000"),
            Alumno(7, "Agustin", "Gomez", "Rosario", "3000"),
            Alumno(8, "Martin", "Fulano", "Córdoba", "2000"),
            Alumno(9, "Teresa", "Gomez", "Rosario", "3000"),
            Alumno(10, "Esteban", "Musolini", "Mendoza", "4000")
        )
    }
}


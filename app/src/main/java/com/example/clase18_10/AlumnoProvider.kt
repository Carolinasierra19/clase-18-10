package com.example.clase18_10


import com.example.clase18_10.model.Alumno

object AlumnoProvider {
    fun getInitialAlumnos(): List<Alumno> {
        return listOf(
            Alumno(0, "Juan", "Pérez", "Buenos Aires", "1000"),
            Alumno(1, "María", "Gómez", "Córdoba", "2000"),
            Alumno(2, "Carlos", "Fernández", "Rosario", "3000"),
            Alumno(3, "Ana", "López", "Mendoza", "4000")
        )
    }
}

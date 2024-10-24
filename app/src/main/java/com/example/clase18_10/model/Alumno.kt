package com.example.clase18_10.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
// user se hace ahora entidad
// entity y primary key son sumamente necesarios
//el column info no podes utilizarlo si queres cambiar el nombre de una columna en la base de datos que difiera del nombre del campo en la clase Kotlin

@Entity(tableName = "alumnos")
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "first_name") val name: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "city_name") val city: String,
    @ColumnInfo(name = "postal_code") val CP: String
)




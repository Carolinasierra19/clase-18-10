package com.example.clase18_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase18_10.adapter.AlumnoAdapter
import com.example.clase18_10.dataBase.AppDatabase
import com.example.clase18_10.model.Alumno
import com.example.clase18_10.repository.AlumnoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var alumnoAdapter: AlumnoAdapter
    private lateinit var repository: AlumnoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // Inicializar el repositorio
        val db = AppDatabase.getDatabase(this)
        repository = AlumnoRepository(db.alumnoDao())

        // Limpiar la tabla e insertar el alumno en el repositorio
        lifecycleScope.launch(Dispatchers.IO) {
            repository.clearAndInsertAlumno(
                Alumno(0, "Juan", "Pérez", "Buenos Aires", "1000")
            )

            // Obtener los alumnos desde el repositorio y mostrarlos en el RecyclerView
            val alumnosList = repository.getAllAlumnos()
            runOnUiThread {
                alumnoAdapter = AlumnoAdapter(alumnosList)
                recyclerView.adapter = alumnoAdapter
            }
        }
    }
}


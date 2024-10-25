package com.example.clase18_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase18_10.adapter.AlumnoAdapter
import com.example.clase18_10.dataBase.AppDatabase
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

        //  lista mutable vacía
        alumnoAdapter = AlumnoAdapter(mutableListOf())
        recyclerView.adapter = alumnoAdapter

        // Cargar alumnos iniciales desde el repositorio
        lifecycleScope.launch(Dispatchers.IO) {
            repository.clearAndInsertInitialAlumnos()  // Limpiar e insertar alumnos iniciales
            val alumnosList = repository.getAllAlumnos()  // Obtener todos los alumnos

            // Refrescar el adaptador
            runOnUiThread {
                alumnoAdapter.updateData(alumnosList)  // actualizar el adaptador
            }
        }
    }
}



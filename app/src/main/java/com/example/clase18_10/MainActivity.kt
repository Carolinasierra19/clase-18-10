package com.example.clase18_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase18_10.adapter.AlumnoAdapter
import com.example.clase18_10.dataBase.AppDatabase
import com.example.clase18_10.model.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var alumnoAdapter: AlumnoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val db = AppDatabase.getDatabase(this)

        // Insertar alumnos en la base de datos (esto debería hacerse una sola vez, puedes evitar repetirlo)
        lifecycleScope.launch(Dispatchers.IO) {
            db.alumnoDao().insertAlumno(
                Alumno(0, "Juan", "Pérez", "Buenos Aires", "1000")
            )

        }

        // Obtener los alumnos desde la base de datos y mostrarlos en el RecyclerView
        lifecycleScope.launch(Dispatchers.IO) {
            val alumnosList = db.alumnoDao().getAllAlumnos()
            runOnUiThread {
                alumnoAdapter = AlumnoAdapter(alumnosList)
                recyclerView.adapter = alumnoAdapter
            }
        }
    }
}

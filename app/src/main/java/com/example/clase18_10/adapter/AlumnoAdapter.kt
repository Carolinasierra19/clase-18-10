package com.example.clase18_10.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clase18_10.R
import com.example.clase18_10.model.Alumno


class AlumnoAdapter(private val alumnosList: List<Alumno>) :
    RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumno, parent, false)
        return AlumnoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val currentAlumno = alumnosList[position]
        holder.bind(currentAlumno)
    }

    override fun getItemCount(): Int = alumnosList.size

    class AlumnoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val alumnoName = itemView.findViewById<TextView>(R.id.tvName)
        private val alumnoCity = itemView.findViewById<TextView>(R.id.tvCity)
        private val alumnoCP = itemView.findViewById<TextView>(R.id.tvCP)
        private val alumnoID = itemView.findViewById<TextView>(R.id.tvId)

        fun bind(alumno: Alumno) {
            alumnoName.text = "${alumno.name} ${alumno.lastName}"
            alumnoCity.text = alumno.city
            alumnoCP.text = alumno.CP
            alumnoID.text = alumno.id.toString()



        }
    }

}


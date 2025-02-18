package com.example.kevin_araneda_20250217

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(private val usuarios: List<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewRut: TextView = itemView.findViewById(R.id.textViewRut)
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewApellido: TextView = itemView.findViewById(R.id.textViewApellido)
        val textViewFecha: TextView = itemView.findViewById(R.id.textViewFecha)
        val textViewHora: TextView = itemView.findViewById(R.id.textViewHora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.textViewRut.text = usuario.rut
        holder.textViewNombre.text = usuario.nombre
        holder.textViewApellido.text = usuario.apellido
        holder.textViewFecha.text = usuario.fecha
        holder.textViewHora.text = usuario.hora
    }

    override fun getItemCount() = usuarios.size
}
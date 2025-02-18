package com.example.kevin_araneda_20250217

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ConsultaActivity : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var usuarioAdapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)

        databaseHelper = DatabaseHelper(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtener los datos de la base de datos
        val usuarios = obtenerDatos()

        // Configurar el adaptador
        usuarioAdapter = UsuarioAdapter(usuarios)
        recyclerView.adapter = usuarioAdapter
    }

    private fun obtenerDatos(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        val db = databaseHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)

        if (cursor.moveToFirst()) {
            do {
                val rut = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RUT))
                val nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE))
                val apellido = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDO))
                val fecha = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FECHA))
                val hora = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HORA))

                usuarios.add(Usuario(rut, nombre, apellido, fecha, hora))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return usuarios
    }
}
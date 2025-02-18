package com.example.kevin_araneda_20250217

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Locale
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //declarar la variable databaseHelper
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //codigo para obtener la hora al presionar el editText de la fecha

        val obtenerHora: EditText = findViewById(R.id.ObtenerHora)
        obtenerHora.setOnClickListener {
            // Obtener la hora actual
            val calendario = Calendar.getInstance()
            val hora = calendario.get(Calendar.HOUR_OF_DAY)
            val minutos = calendario.get(Calendar.MINUTE)

            // Crear el TimePickerDialog
            val timePickerDialog = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    // Formatear la hora y mostrarla en el EditText usando Locale
                    val formateoHora = String.format(Locale("es","CL"), "%02d:%02d", hourOfDay, minute)
                    obtenerHora.setText(formateoHora)
                },
                hora,
                minutos,
                true
            )
            timePickerDialog.show()
        }

        //Codigo para seleccionar la fecha al presionar el edit Text de la fecha

        val obtenerFecha = findViewById<EditText>(R.id.ObtenerFecha)
        obtenerFecha.setOnClickListener{
            //obtener la fecha actual
            val calendario = Calendar.getInstance()
            val ano = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            //Crear el datePickerDialog

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Formatear la fecha y mostrarla en el EditText
                    val formateoFecha = String.format(Locale("es", "CL"), "%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                    obtenerFecha.setText(formateoFecha)
                },
                ano,
                mes,
                dia
            )
            datePickerDialog.show()
        }

        val obtenerRut: EditText = findViewById(R.id.ObtenerRut)
        val obtenerNombre: EditText = findViewById(R.id.ObtenerNombre)
        val obtenerApellido: EditText = findViewById(R.id.ObtenerApellido)
        val botonRegistro: Button = findViewById(R.id.BotonRegistro)

        //guardar los datos obtenidos en la db
        botonRegistro.setOnClickListener{
            val rut = obtenerRut.text.toString()
            val nombre = obtenerNombre.text.toString()
            val apellido = obtenerApellido.text.toString()
            val fecha = obtenerFecha.text.toString()
            val hora = obtenerHora.text.toString()
            if (rut.isNotEmpty() && nombre.isNotEmpty() && apellido.isNotEmpty() && fecha.isNotEmpty() && hora.isNotEmpty()) {
                val result = databaseHelper.insertData(rut, nombre, apellido, fecha, hora)
                if (result != -1L) {
                    Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        //Dar una función al botón consultar

        val botonConsulta = findViewById<Button>(R.id.ObtenerConsulta)
        botonConsulta.setOnClickListener{
            val intento = Intent(this, ConsultaActivity::class.java)
            startActivity(intento)
        }



    }
}
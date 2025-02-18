package com.example.kevin_araneda_20250217

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//definir constantes y columnas de la base de datos
    companion object {
        private const val DATABASE_NAME = "registro.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "usuarios"
        const val COLUMN_ID = "id"
        const val COLUMN_RUT = "rut"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_APELLIDO = "apellido"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_HORA = "hora"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_RUT + " TEXT,"
                + COLUMN_NOMBRE + " TEXT,"
                + COLUMN_APELLIDO + " TEXT,"
                + COLUMN_FECHA + " TEXT,"
                + COLUMN_HORA + " TEXT" + ")")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(rut: String, nombre: String, apellido: String, fecha: String, hora: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_RUT, rut)
        contentValues.put(COLUMN_NOMBRE, nombre)
        contentValues.put(COLUMN_APELLIDO, apellido)
        contentValues.put(COLUMN_FECHA, fecha)
        contentValues.put(COLUMN_HORA, hora)

        return db.insert(TABLE_NAME, null, contentValues)
    }
}
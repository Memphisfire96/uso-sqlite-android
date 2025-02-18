# Proyecto: Control de Asistencia

## Descripción
Este proyecto es una aplicación móvil desarrollada en **[Kotlin](https://kotlinlang.org/)** que permite registrar y consultar la asistencia de los trabajadores. La aplicación utiliza **[SQLite](https://www.sqlite.org/index.html)** para la persistencia de datos y proporciona una interfaz sencilla para capturar la información de los empleados, incluyendo su **RUT**, **nombre**, **apellido**, **fecha** y **hora** de asistencia.

## Características
- **Registro de asistencia**: Permite ingresar datos como **RUT**, **nombre**, **apellido**, **fecha** y **hora**.
- **Selección de fecha y hora**: Uso de [`DatePickerDialog`](https://developer.android.com/reference/android/app/DatePickerDialog) y [`TimePickerDialog`](https://developer.android.com/reference/android/app/TimePickerDialog) para facilitar la selección.
- **Base de datos local**: Implementación con **[SQLite](https://developer.android.com/training/data-storage/sqlite)** para almacenar los datos.
- **Consulta de registros**: Listado de los datos almacenados mediante **[`RecyclerView`](https://developer.android.com/guide/topics/ui/layout/recyclerview)**.

## Tecnologías utilizadas
- **[Kotlin](https://kotlinlang.org/)**
- **[SQLite](https://www.sqlite.org/index.html)**
- **[RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)**
- **[Android SDK](https://developer.android.com/studio)**

## Instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Memphisfire96/uso-sqlite-android
   ```
2. Abrir el proyecto en **[Android Studio](https://developer.android.com/studio)**.
3. Compilar y ejecutar en un emulador o dispositivo físico.

## Uso
1. Ingresar los datos en los campos correspondientes.
2. Seleccionar la **fecha** y **hora** de asistencia.
3. Guardar el registro en la **base de datos**.
4. Consultar los registros en la pantalla de **consulta**.

## Estructura del Proyecto
- [`MainActivity.kt`](app/src/main/java/com/example/kevin_araneda_20250217/MainActivity.kt): Actividad principal que permite registrar la asistencia.
- [`ConsultaActivity.kt`](app/src/main/java/com/example/kevin_araneda_20250217/ConsultaActivity.kt): Muestra los registros almacenados en la base de datos.
- [`DatabaseHelper.kt`](app/src/main/java/com/example/kevin_araneda_20250217/DatabaseHelper.kt): Clase para la gestión de la base de datos **SQLite**.
- [`Usuario.kt`](app/src/main/java/com/example/kevin_araneda_20250217/Usuario.kt): Modelo de datos para la representación de un usuario.
- [`UsuarioAdapter.kt`](app/src/main/java/com/example/kevin_araneda_20250217/UsuarioAdapter.kt): Adaptador para el **`RecyclerView`**.

## Autor
**Kevin Araneda** - [20250217](https://github.com/MemphisFire96)




package com.example.alarmapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private var textViewHora : TextView? = null
    var btnOK : Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewHora = findViewById(R.id.textViewHora)
        btnOK = findViewById(R.id.btnOK)

        val gDatos = GuardarDatos(applicationContext)
        textViewHora?.text = gDatos.obtenerHora().toString() + ":" + gDatos.obtenerMinutos().toString()

        btnOK?.setOnClickListener {
            val tiempo = TimePicker()
            val fragmentManager = fragmentManager
            tiempo.show(fragmentManager, "Selecciona una hora")
        }
    }

    @SuppressLint("SetTextI18n")
    fun setearHora(hora: Int, minutos: Int) {
        textViewHora?.text = "$hora:$minutos"

        val guardarDatos = GuardarDatos(applicationContext)
        guardarDatos.programarAlarma()
        guardarDatos.sharedPrefs(hora, minutos)
    }
}

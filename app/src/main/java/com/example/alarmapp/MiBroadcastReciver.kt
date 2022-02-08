package com.example.alarmapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MiBroadcastReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ("com.gestoralarma")) {

            val msg = intent.extras
            Toast.makeText(context, msg?.getString("mensaje"), Toast.LENGTH_LONG).show()

            val notificacion = NotificacionPush()
            notificacion.notifiacion(context!!, msg?.getString("mensaje")!!, 1 )
        } else if (intent?.action == ("android.intent.action.BOOT_COMPLETED")){
            val gDatos = GuardarDatos(context!!)
            gDatos.programarAlarma()
        }
    }
}
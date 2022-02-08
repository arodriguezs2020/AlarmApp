package com.example.alarmapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificacionPush {

    val NOTIFICACION = "peticion nueva"
    val NOTIFICATION_CHANNEL_ID = "MiChannelID"

    fun notifiacion(context: Context, mensaje: String, numero: Int) {
        val intent = Intent(context, MainActivity::class.java)
        val gestorNotificacion = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notifChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "Mi notificacion",
            NotificationManager.IMPORTANCE_HIGH)
            notifChannel.description = "Descripcion"
            notifChannel.lightColor = Color.RED
            notifChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notifChannel.enableVibration(true)
            gestorNotificacion.createNotificationChannel(notifChannel)
        }

        val builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("AlarmApp")
            .setContentText(mensaje)
            .setColorized(true)
            .setColor(Color.RED)
            .setNumber(numero)
            .setSmallIcon(androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .setContentIntent(PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT))
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT in 19..25) {
            gestorNotificacion.notify(NOTIFICACION, 0, builder.build())
        } else {
            gestorNotificacion.notify(NOTIFICACION.hashCode(), builder.build())
        }
    }
}
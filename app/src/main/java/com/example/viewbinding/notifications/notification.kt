package com.example.viewbinding.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.viewbinding.MainActivity


class notification : Service() {
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    private lateinit var builder: NotificationCompat.Builder

    private val CANAL_ID: String= "mi_canal"
    private val NOTIFICACION_ID: Int= 1

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel = NotificationChannel(CANAL_ID, "Mis Notificaciones", NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.lightColor= Color.GREEN
            notificationChannel.setDescription("Descripcion")
            notificationManager.createNotificationChannel(notificationChannel)
        }else {
            builder = NotificationCompat.Builder(this, CANAL_ID)
                .setContentTitle("Titulo")
                .setContentText("Notificacion")
        }
        notificationManager.notify(NOTIFICACION_ID, builder.build())
        return START_STICKY
        //return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}
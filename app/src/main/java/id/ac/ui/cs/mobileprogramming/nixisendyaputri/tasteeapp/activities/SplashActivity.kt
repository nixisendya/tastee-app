package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.activities

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.MyNotificationPublisher
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import java.util.*


class SplashActivity : AppCompatActivity(){

    private val splashTime = 3000L
    private lateinit var myHandler : Handler
    val NOTIFICATION_CHANNEL_ID = "10001"
    private val default_notification_channel_id = "default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        scheduleNotification(getNotification( "Try one of our easy-to-follow delicious recipes!" ))

        myHandler = Handler()

        myHandler.postDelayed({
            goToMainActivity()
        },splashTime)
    }

    private fun goToMainActivity(){

        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }


    private fun scheduleNotification(notification: Notification) {
        val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, 1)
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 11)

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    private fun getNotification(content: String): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(application)
            .addNextIntent(intent)
            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, default_notification_channel_id)
        builder.setContentTitle("Feeling hungry? Not sure what to eat?")
        builder.setContentText(content)
        builder.setSmallIcon(R.mipmap.ic_launcher_round)
        builder.setAutoCancel(true)
        builder.setChannelId(NOTIFICATION_CHANNEL_ID)
        builder.setContentIntent(pendingIntent)
        return builder.build()
    }
}

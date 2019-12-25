package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicPlayer : Service() {

    private lateinit var player : MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player = MediaPlayer.create(this, R.raw.cooking_mama_ost)
        player.isLooping = true
        player.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}
package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R


class MainActivity : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

    }
}

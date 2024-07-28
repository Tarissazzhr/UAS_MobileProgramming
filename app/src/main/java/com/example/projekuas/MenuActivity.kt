package com.example.projekuas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var buttonHome: Button
    private lateinit var buttonMenu: Button
    private lateinit var buttonAbout: Button
    private lateinit var buttonProfile: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        buttonHome = findViewById(R.id.buttonHome)
        buttonMenu = findViewById(R.id.buttonMenu)
        buttonAbout = findViewById(R.id.buttonAbout)
        buttonProfile = findViewById(R.id.buttonProfile)

        buttonHome.setOnClickListener {
            val homeIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(homeIntent)
        }
        buttonMenu.setOnClickListener {
            val menuIntent = Intent(applicationContext, MenuActivity::class.java)
            startActivity(menuIntent)
        }
        buttonAbout.setOnClickListener {
            val aboutIntent = Intent(applicationContext, AboutActivity::class.java)
            startActivity(aboutIntent)
        }
        buttonProfile.setOnClickListener {
            val profileIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
    }
}
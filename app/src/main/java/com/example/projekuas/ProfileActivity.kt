package com.example.projekuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var buttonHome: Button
    private lateinit var buttonMenu: Button
    private lateinit var buttonAbout: Button
    private lateinit var buttonLogOut: Button
    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Inisialisasi tombol-tombol
        buttonHome = findViewById(R.id.buttonHome)
        buttonMenu = findViewById(R.id.buttonMenu)
        buttonAbout = findViewById(R.id.buttonAbout)
        buttonLogOut = findViewById(R.id.buttonLogOut)
        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        showUserData()

        // Atur OnClickListener
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
        buttonLogOut.setOnClickListener {
            val logoutIntent = Intent(applicationContext, Login::class.java)
            startActivity(logoutIntent)
        }
    }

    private fun showUserData() {
        val intent = intent
        val usernameUser = intent.getStringExtra("username")
        val emailUser = intent.getStringExtra("email")
        val passwordUser = intent.getStringExtra("password")

        username.text = usernameUser
        email.text = emailUser
        password.text = passwordUser
    }
}

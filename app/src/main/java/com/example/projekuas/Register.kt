package com.example.projekuas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var buttonSignUp: Button
    private lateinit var textViewSignIn: TextView

    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom)
            WindowInsetsCompat.CONSUMED
        }
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.statusBars())

        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        buttonSignUp = findViewById(R.id.buttonSignUp)
        textViewSignIn = findViewById(R.id.textViewSignIn)

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projekuas-d3a2d-default-rtdb.firebaseio.com/")

        buttonSignUp.setOnClickListener {
            val Username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val Password = etPassword.text.toString()

            if (Username.isEmpty() || email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(applicationContext, "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show()
            } else {
                database = FirebaseDatabase.getInstance().getReference("users")
                database.child(Username).child("Username").setValue(Username)
                database.child(Username).child("Email").setValue(email)
                database.child(Username).child("Password").setValue(Password)

                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_SHORT).show()
                val register = Intent(applicationContext, Login::class.java)
                startActivity(register)
            }
        }

        textViewSignIn.setOnClickListener {
            val login = Intent(applicationContext, Login::class.java)
            startActivity(login)
        }
    }
}

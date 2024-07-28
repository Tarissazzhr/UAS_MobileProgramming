package com.example.projekuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var buttonLogIn: Button
    private lateinit var textViewRegis: TextView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textViewRegis = findViewById(R.id.textViewRegis)
        buttonLogIn = findViewById(R.id.buttonLogIn)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        textViewRegis.setOnClickListener {
            val register = Intent(applicationContext, Register::class.java)
            startActivity(register)
        }

        buttonLogIn.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            database = FirebaseDatabase.getInstance().getReference("users")

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Username Atau Password Salah", Toast.LENGTH_SHORT).show()
            } else {
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.child(username).exists()) {
                            if (snapshot.child(username).child("Password").getValue(String::class.java) == password) {
                                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_SHORT).show()
                                val masuk = Intent(applicationContext, MainActivity::class.java)
                                startActivity(masuk)
                                finish()
                            } else {
                                Toast.makeText(applicationContext, "Password Salah", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Data Belum Terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle error
                    }
                })
            }
        }
    }
}

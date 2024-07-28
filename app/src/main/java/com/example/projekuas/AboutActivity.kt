package com.example.projekuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AboutActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var buttonHome: Button
    private lateinit var buttonMenu: Button
    private lateinit var buttonProfile: Button
    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about) // Ensure this is the correct layout file

        // Inisialisasi tombol-tombol
        buttonHome = findViewById(R.id.buttonHome)
        buttonMenu = findViewById(R.id.buttonMenu)
        buttonProfile = findViewById(R.id.buttonProfile)

        // Atur OnClickListener
        buttonHome.setOnClickListener {
            val homeIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(homeIntent)
        }
        buttonMenu.setOnClickListener {
            val menuIntent = Intent(applicationContext, MenuActivity::class.java)
            startActivity(menuIntent)
        }
        buttonProfile.setOnClickListener {
            val profileIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(profileIntent)
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker for the location and move the camera
        val lokasi = LatLng(-6.37111086808707, 106.82469608163747)
        mMap?.apply {
            addMarker(MarkerOptions().position(lokasi).title("Restoranich!"))
            moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 15f))
        }
    }
}

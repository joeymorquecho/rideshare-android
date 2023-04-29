package com.example.hc2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    // Fragments
    private lateinit var riderFragment: RiderFragment
    private lateinit var driverFragment: DriverFragment

    // Views
    private lateinit var bnv: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        riderFragment = RiderFragment.newInstance()
        driverFragment = DriverFragment.newInstance()
        bnv = findViewById(R.id.bottom_nav_view)

        // Set up Navigation
        bnv.setOnItemSelectedListener {
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.rider_item -> {
                    transaction.replace(R.id.fragment_holder, riderFragment).commit()
                }
                R.id.driver_item -> {
                    transaction.replace(R.id.fragment_holder, driverFragment).commit()
                }
                R.id.profile_item -> {
                    transaction.commit()
                }
            }
            true
        }

        // Set initial screen
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, riderFragment).commit()

    }
}
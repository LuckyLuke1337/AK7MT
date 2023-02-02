package com.example.pocketpharma


import com.google.android.material.snackbar.Snackbar

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.pocketpharma.databinding.ActivityMainBinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button in the layout
        val searchButton = findViewById<Button>(R.id.searchButton)
        val favoritesButton = findViewById<Button>(R.id.favoritesButton)

        // Set an OnClickListener on the button
        searchButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, SearchActivity::class.java)
            // Start the second activity
            startActivity(intent)
        }

        favoritesButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, FavoritesActivity::class.java)
            // Start the second activity
            startActivity(intent)
        }
    }
}
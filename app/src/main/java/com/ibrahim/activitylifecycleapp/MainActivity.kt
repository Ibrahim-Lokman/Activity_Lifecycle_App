package com.ibrahim.activitylifecycleapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ibrahim.activitylifecycleapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var isFirstLoad = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }
        binding.textViewRefreshStatus.text = "Welcome to Activity Life Cycle App"


        Log.d("Sajeet Create", "I'm in onCreate()")
    }

    override fun onResume() {
        super.onResume()

        if (isFirstLoad) {
            binding.textViewRefreshStatus.text = "Welcome to app! First Load."
            isFirstLoad = false
        } else {
            val currentTimeMillis = System.currentTimeMillis()
            val currentTime = Date(currentTimeMillis)

            // Format the time to include hours, minutes, seconds, and milliseconds
            val sdf = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
            val formattedTime = sdf.format(currentTime)

            binding.textViewRefreshStatus.text = "Welcome to app! \n onResume : Current time in seconds: $formattedTime"

        }
       }


}
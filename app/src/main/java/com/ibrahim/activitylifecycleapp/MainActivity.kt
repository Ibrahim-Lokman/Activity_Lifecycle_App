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
import java.util.Timer
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var seconds = 0
    val timer:Timer = fixedRateTimer(period = 1000L) {
        runOnUiThread {
            seconds++
            binding.textViewRefreshStatus.text = "Time is $seconds seconds"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }

        Log.d("Sajeet Create", "I'm in onCreate()")



    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }


 }
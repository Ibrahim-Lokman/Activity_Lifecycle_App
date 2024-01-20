package com.ibrahim.activitylifecycleapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "I'm in onCreate()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Create", "I'm in onCreate()")
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "I'm in onStart()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Start", "I'm in onStart()")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "I'm in onResume()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Resume", "I'm in onResume()")

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "I'm in onPause()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Pause", "I'm in onPause()")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "I'm in onStop()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Stop", "I'm in onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "I'm in onDestroy()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Destroy", "I'm in onDestroy()")
    }
}
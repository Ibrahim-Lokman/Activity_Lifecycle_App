package com.ibrahim.activitylifecycleapp

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

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "I'm in onDestroy()", Toast.LENGTH_SHORT).show()
        Log.d("Sajeet Destroy", "I'm in onDestroy()")
    }
}
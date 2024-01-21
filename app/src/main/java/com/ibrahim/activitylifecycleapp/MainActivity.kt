package com.ibrahim.activitylifecycleapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.addCallback
import com.ibrahim.activitylifecycleapp.databinding.ActivityMainBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Timer
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var seconds = 0
    private lateinit var timer:Timer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savedDataPreview.text = savedInstanceState?.getString("savedTextViewMessage")

        binding.btnExit.setOnClickListener { showDialog() }

        binding.btnSave.setOnClickListener {
           saveMessage()
        }



       onBackPressedDispatcher.addCallback{
           showDialog()
           File(filesDir, "onBackPresed.txt").writeText("onBackPresed".toString())


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextViewMessage = binding.editText.text.toString()
        outState.putString("savedTextViewMessage", savedTextViewMessage)
    }

    private fun saveMessage() {

        val userMsg = binding.editText.text
        File(filesDir, "usermsg.txt").writeText(userMsg.toString())
        binding.savedDataPreview.text = "Your message : \n\n$userMsg"
    }

    override fun onResume() {
        super.onResume()
      timer =  fixedRateTimer(period = 1000L) {
            runOnUiThread {
                seconds++
                binding.textViewRefreshStatus.text = "Time is $seconds seconds"
            }
        }

    }

//    override fun onPause() {
//        super.onPause()
//        timer.cancel()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        val userMsg = binding.textViewRefreshStatus.text
//        File(filesDir, "destroytimelog.txt").writeText(userMsg.toString())
//    }

    private fun showDialog(){
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes"){_, _ ->
                finish()
            }
            .setNegativeButton("No"){dialog, which ->
                dialog.dismiss()
            }
            .setNeutralButton("Report Bug"
            ) { _, _ ->
                Toast.makeText(
                    this@MainActivity,
                    "Bug Reported",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .create().show()
    }




 }
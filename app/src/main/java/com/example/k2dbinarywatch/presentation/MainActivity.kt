package com.example.k2dbinarywatch.presentation

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.k2dbinarywatch.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val myDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
            current.format(formatter)
        } else {
            val date = Date()
            val formatter = SimpleDateFormat("HH:mma")
            formatter.format(date)

        }
        var binaryHours = myDate[0].toString()
        binaryHours += myDate[1]
        var binaryMinutes = myDate[3].toString()
        binaryMinutes += myDate[4]
        var binarySeconds = myDate[6].toString()
        binarySeconds += myDate[7]
        Toast.makeText(this, myDate, Toast.LENGTH_SHORT).show()
        binding.hoursNumbers.text = binaryHours.toInt().toString(2)
        binding.minutesNumbers.text = binaryMinutes.toInt().toString(2)
        binding.secondsNumbers.text = binarySeconds.toInt().toString(2)
    }

}
package com.example.k2dbinarywatch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k2dbinarywatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hoursNumbers.text = ""
        binding.minutesNumbers.text = ""
        binding.secondsNumbers.text = ""
    }


}
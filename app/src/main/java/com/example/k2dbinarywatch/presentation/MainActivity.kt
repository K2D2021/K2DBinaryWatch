package com.example.k2dbinarywatch.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.k2dbinarywatch.databinding.ActivityMainBinding
import com.example.k2dbinarywatch.domain.updateTime
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val scope = MainScope()
        scope.launch {

            while (true) {
                delay(1000)
                val myDate = updateTime()

                var binaryHours = myDate[0].toString()
                binaryHours += myDate[1]
                var binaryMinutes = myDate[3].toString()
                binaryMinutes += myDate[4]
                var binarySeconds = myDate[6].toString()
                binarySeconds += myDate[7]
                binding.hoursNumbers.text = binaryHours.toInt().toString(2)
                binding.minutesNumbers.text = binaryMinutes.toInt().toString(2)
                binding.secondsNumbers.text = binarySeconds.toInt().toString(2)
            }
        }
    }
}



package com.example.k2dbinarywatch.domain

import android.annotation.SuppressLint
import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@SuppressLint("SimpleDateFormat")
fun updateTime(): String {
    val updatedTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        current.format(formatter)
    } else {
        val date = Date()
        val formatter = SimpleDateFormat("HH:mma")
        formatter.format(date)

    }
    return updatedTime
}
package com.thefourthspecies.interpill.model

import android.app.PendingIntent

data class Prescription (
    val brandName : String,
    val genericName : String,
    val dosage : List<Schedule>
)

data class Schedule(
    val dose : String,
    val time : PillTime,
    val alarm : PendingIntent
)

data class PillTime(
    val hours : Int,
    val minutes : Int,
    val isInterval : Boolean
) {
    override fun toString(): String {
        if (isInterval) {
            return "+$hours hrs $minutes mins"
        } else {
            val hr = if (hours < 10) "0$hours" else hours.toString()
            val min = if (minutes < 10) "0$minutes" else minutes.toString()
            return "$hr:$min"
        }
    }
}



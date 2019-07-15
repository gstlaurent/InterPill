package com.thefourthspecies.interpill.model

data class PillAlarm(val dosage : String, val scheduledTime : PillTime, val actualTime : PillTime?, val isOver : Boolean)



/**
 * An item representing a set of alarms for a pill
 */
data class PrescriptionItem(val drugName: String, val alarms: List<PillAlarm>) {
    override fun toString(): String = drugName

    // TODO: non-randomize
    val nextScheduled : PillTime
        get() {
            val alarm = alarms.randomItem()!!
            return alarm.actualTime ?: alarm.scheduledTime
        }

}

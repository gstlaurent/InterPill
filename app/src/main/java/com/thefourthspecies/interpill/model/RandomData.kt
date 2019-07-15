package com.thefourthspecies.interpill.model

import kotlin.random.Random

val DRUGS = listOf(
    "Cortef",
    "Synthroid",
    "Acetaminophen      ",
    "Adderall           ",
    "Alprazolam         ",
    "Amitriptyline      ",
    "Amlodipine         ",
    "Amoxicillin        ",
    "Ativan             ",
    "Atorvastatin       ",
    "Azithromycin       ",
    "Ciprofloxacin      ",
    "Citalopram         ",
    "Clindamycin        ",
    "Clonazepam         ",
    "Codeine            ",
    "Cyclobenzaprine    ",
    "Cymbalta           ",
    "Doxycycline        ",
    "Gabapentin         ",
    "Hydrochlorothiazide",
    "Ibuprofen          ",
    "Lexapro            ",
    "Lisinopril         ",
    "Loratadine         ",
    "Lorazepam          ",
    "Losartan           ",
    "Lyrica             ",
    "Meloxicam          ",
    "Metformin          ",
    "Metoprolol         ",
    "Naproxen           ",
    "Omeprazole         ",
    "Oxycodone          ",
    "Pantoprazole       ",
    "Prednisone         ",
    "Tramadol           ",
    "Trazodone          ",
    "Viagra             ",
    "Wellbutrin         ",
    "Xanax              ",
    "Zoloft             "
)

fun randomDrug() : String = DRUGS.randomItem()!!.trim()


val DOSAGES = listOf(
    "1",
    "2",
    "1 mg",
    "5 mg",
    "10 mg",
    "20 mg",
    "50 mg",
    "75 mg",
    "100 mg"
)

fun randomDosage() : String = DOSAGES.randomItem()!!.trim()

fun randomTime(isInterval : Boolean) : PillTime {
    val hours = if (isInterval) {
        Random.nextInt(1, 6)
    } else {
        Random.nextInt(24)
    }
    val minutes = listOf(0, 15, 30, 45).randomItem()!!
    return PillTime(hours, minutes, isInterval)
}

fun randomPillAlarm(isInterval: Boolean) : PillAlarm {
    val dosage = randomDosage()
    val scheduledTime = randomTime(isInterval)
    val actualTime = if (isInterval) randomTime(false) else null
    val isOver = Random.nextBoolean()
    return PillAlarm(dosage, scheduledTime, actualTime, isOver)
}

fun randomPillItem() : PrescriptionItem {
    val alarms = mutableListOf<PillAlarm>(randomPillAlarm(false))
    repeat(Random.nextInt(4)) {
        alarms.add(randomPillAlarm(true))
    }
    return PrescriptionItem(randomDrug(), alarms)
}


// https://stackoverflow.com/a/47850157
/**
 * Returns a random element.
 */
fun <E> List<E>.randomItem(): E? = if (size > 0) get(Random.nextInt(size)) else null



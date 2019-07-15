package com.thefourthspecies.interpill.model

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PillContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<PrescriptionItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PrescriptionItem> = HashMap()

    private val COUNT = 10

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(randomPillItem())
        }
    }

    private fun addItem(item: PrescriptionItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.drugName, item)
    }
}


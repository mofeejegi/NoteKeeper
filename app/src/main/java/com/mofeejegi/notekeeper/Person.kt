package com.mofeejegi.notekeeper

import android.util.Patterns

class Person (val gender: String, var weightLbs: Double, val name: String = "Anon"){

    var weightKilos: Double
        get() = weightLbs / 2.2
        set(value) {
            weightLbs = value * 2.2
        }

    fun eatDessert(addedIceCream: Boolean = true) {
        weightLbs += if (addedIceCream) 4.0 else 2.0
    }

    fun calcGoalWeightLbs(lbsToLose: Double = 10.0): Double {
        return weightLbs - lbsToLose
    }
}
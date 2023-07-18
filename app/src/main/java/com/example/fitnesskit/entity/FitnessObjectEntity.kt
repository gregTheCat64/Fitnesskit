package com.example.fitnesskit.entity

import androidx.room.Entity
import com.example.fitnesskit.models.Coach
import com.example.fitnesskit.models.FitnessObject
import com.example.fitnesskit.models.Option
import com.example.fitnesskit.models.Tab
import com.example.fitnesskit.models.Training

@Entity
data class FitnessObjectEntity (
    val trainings: List<Training>,
    val option: Option,
    val tabs: List<Tab>,
    val coaches: List<Coach>
        )

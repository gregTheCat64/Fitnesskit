package com.example.fitnesskit.models

import com.example.fitnesskit.response.TrainingResponse
import com.google.gson.annotations.SerializedName

data class FitnessObject(
    @SerializedName("lessons")
    val trainings: List<TrainingResponse>,
    @SerializedName("option")
    val option: Option,
    @SerializedName("tabs")
    val tabs: List<Tab>,
    @SerializedName("trainers")
    val coaches: List<Coach>
)


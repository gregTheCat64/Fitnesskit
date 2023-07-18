package com.example.fitnesskit.models

import com.google.gson.annotations.SerializedName

data class FitnessObject(
    @SerializedName("lessons")
    val trainings: List<Training>,
    @SerializedName("option")
    val option: Option,
    @SerializedName("tabs")
    val tabs: List<Tab>,
    @SerializedName("trainers")
    val coaches: List<Coach>
)


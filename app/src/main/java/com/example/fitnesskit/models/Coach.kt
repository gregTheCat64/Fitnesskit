package com.example.fitnesskit.models

import androidx.room.Entity
import com.example.fitnesskit.entity.CoachEntity

data class Coach(
    val description: String,
    val full_name: String,
    val id: String,
    val image_url: String,
    val image_url_medium: String,
    val image_url_small: String,
    val last_name: String,
    val name: String,
    val position: String
)

fun Coach.toEntity() = CoachEntity(
    description, full_name, id, image_url, image_url_medium, image_url_small, last_name, name, position
)
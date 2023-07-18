package com.example.fitnesskit.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoachEntity (
    val description: String,
    val full_name: String,
    @PrimaryKey
    val id: String,
    val image_url: String,
    val image_url_medium: String,
    val image_url_small: String,
    val last_name: String,
    val name: String,
    val position: String
        )
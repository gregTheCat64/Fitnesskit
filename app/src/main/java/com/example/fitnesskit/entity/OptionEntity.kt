package com.example.fitnesskit.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OptionEntity (
    @PrimaryKey
    val club_name: String,
    val link_android: String,
    val link_ios: String,
    val primary_color: String,
    val secondary_color: String
)
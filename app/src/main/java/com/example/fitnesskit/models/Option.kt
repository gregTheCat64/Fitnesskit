package com.example.fitnesskit.models

import com.example.fitnesskit.entity.OptionEntity

data class Option(
    val club_name: String,
    val link_android: String,
    val link_ios: String,
    val primary_color: String,
    val secondary_color: String
)

fun Option.toEntity() = OptionEntity(
    club_name, link_android, link_ios, primary_color, secondary_color
)
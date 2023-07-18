package com.example.fitnesskit.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TabsEntity (
    @PrimaryKey
    val id: Int,
    val name: String
)
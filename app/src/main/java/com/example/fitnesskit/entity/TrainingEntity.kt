package com.example.fitnesskit.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainings")
data class TrainingEntity (
    @PrimaryKey
    val appointment_id: String,
    val available_slots: Int,
    val client_recorded: Boolean,
    val coach_id: String,
    val color: String,
    val commercial: Boolean,
    val date: String,
    val description: String,
    val endTime: String,
    val is_cancelled: Boolean,
    val name: String,
    val place: String,
    val service_id: String,
    val startTime: String,
    val tab: String,
    val tab_id: Int
        )


package com.example.fitnesskit.models

import com.example.fitnesskit.entity.TrainingEntity
import com.example.fitnesskit.utils.asString
import com.example.fitnesskit.utils.toLocalDate
import java.time.LocalDate

data class Training(
    val appointment_id: String,
    val available_slots: Int,
    val client_recorded: Boolean,
    val coach_id: String,
    val color: String,
    val commercial: Boolean,
    val date: LocalDate,
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

fun Training.toEntity() = TrainingEntity(
    appointment_id, available_slots, client_recorded, coach_id, color, commercial, date.toString(), description, endTime, is_cancelled, name, place, service_id, startTime, tab, tab_id
)

fun TrainingEntity.toModel() = Training(
    appointment_id, available_slots, client_recorded, coach_id, color, commercial, date.toLocalDate(), description, endTime, is_cancelled, name, place, service_id, startTime, tab, tab_id
)

package com.example.fitnesskit.models

import com.example.fitnesskit.entity.TrainingWithCoachAndTabEntity
import com.example.fitnesskit.utils.toLocalDate
import java.time.LocalDate

sealed class TrainingItem{
    abstract val date: LocalDate
}

data class DateSeparator(
    override val date: LocalDate,
) : TrainingItem()

data class TrainingWithCoachAndTab(
    override val date: LocalDate,
    val training: Training,
    val coach: Coach?,
    val tab: Tab
): TrainingItem()

//fun TrainingWithCoachAndTab.toEntity() = TrainingWithCoachAndTabEntity(
//    training.date, training.toEntity(),coach?.toEntity(),tab.toEntity()
//)

fun TrainingWithCoachAndTabEntity.toModel() = TrainingWithCoachAndTab(
    training.date.toLocalDate(),  training.toModel(),coach?.toModel(),tab.toModel()
)
package com.example.fitnesskit.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.time.LocalDate

data class TrainingWithCoachAndTabEntity(

    @Embedded val training: TrainingEntity,
    @Relation(
        parentColumn = "coach_id",
        entityColumn = "id"
    )
    val coach: CoachEntity?,
    @Relation(
        parentColumn = "tab_id",
        entityColumn = "id"
    )
    val tab: TabsEntity
)
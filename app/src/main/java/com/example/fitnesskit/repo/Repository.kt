package com.example.fitnesskit.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.fitnesskit.entity.TrainingWithCoachAndTabEntity
import com.example.fitnesskit.models.TrainingItem
import com.example.fitnesskit.models.TrainingWithCoachAndTab

import kotlinx.coroutines.flow.Flow

interface Repository {
    val data: Flow<PagingData<TrainingWithCoachAndTab>>
    suspend fun getAll()
    suspend fun getById(id: String)
}
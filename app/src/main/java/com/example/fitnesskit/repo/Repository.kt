package com.example.fitnesskit.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.fitnesskit.entity.TrainingItem
import com.example.fitnesskit.entity.TrainingWithCoachAndTab
import kotlinx.coroutines.flow.Flow

interface Repository {
    val data: Flow<PagingData<TrainingItem>>
    suspend fun getAll()
    suspend fun getById(id: String)
}